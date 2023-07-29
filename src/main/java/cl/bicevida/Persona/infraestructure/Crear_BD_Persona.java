package cl.bicevida.Persona.infraestructure;

import cl.bicevida.Persona.domain.DTO.Request_Save_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Crear_Persona;
import cl.bicevida.Persona.utils.Mapper_Persona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import cl.bicevida.TipoPersona.infraestructure.PanacheRepository_TipoPersona;
import cl.bicevida.Utils.RutValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import static cl.bicevida.Persona.utils.Persona_Constants.emailODireccionRequeridos;
import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;
import static cl.bicevida.Utils.Constants.RUT_INVALIDO;

@ApplicationScoped
@Slf4j
public class Crear_BD_Persona implements PuertoSalida_Crear_Persona {

    private final PanacheRepository_Persona repositoryPersona;

    private final PanacheRepository_TipoPersona repositoryTipoPersona;

    private final Mapper_Persona mapper;

    private final RutValidation rutValidation;

    public Crear_BD_Persona(PanacheRepository_Persona repositoryPersona, PanacheRepository_TipoPersona repositoryTipoPersona, Mapper_Persona mapper, RutValidation rutValidation) {
        this.repositoryPersona = repositoryPersona;
        this.repositoryTipoPersona = repositoryTipoPersona;
        this.mapper = mapper;
        this.rutValidation = rutValidation;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class,NotFoundException.class})
    @Override
    public Response_DTO_Persona crear(Request_Save_DTO_Persona dto) {
        log.info("[POST] intentando crear una persona");

        //Validamos que venga o el Email o la direccion
        if(dto.getEmail() == null && dto.getDireccion() == null) {
            throw new BadRequestException(emailODireccionRequeridos);
        }

        //Validamos q el RUT sea valido
        boolean isAValidRut = rutValidation.isAValidRut(dto.getRut(),dto.getDv());
        if(!isAValidRut){
            throw new BadRequestException(RUT_INVALIDO + "  [" + dto.getRut() + "-" + dto.getDv() + "]" );
        }

        //Buscamos SI existe el Tipo de Persona || generamos Error
        Long idTipoPersona = Long.parseLong(dto.getId_tipo_persona());
        Entity_TipoPersona tipoPersona = repositoryTipoPersona.findByIdOptional(idTipoPersona)
                .orElseThrow(()-> new NotFoundException("En la tabla TipoPersona " + NOT_FOUND_BY_ID + idTipoPersona));


        //Creamos el entity desde el DTO
        Entity_Persona entity = crearEntityDesdeDTO(dto,tipoPersona);

        //Persistimos en la BD
        repositoryPersona.persist(entity);

        //Retornamos
        return mapper.crearDTO(entity);
    }

    protected Entity_Persona crearEntityDesdeDTO(Request_Save_DTO_Persona dto,Entity_TipoPersona tipoPersona){
        if(dto.getIdPersonaLegacy() == null){
            return crearEntityConTodosLosCampos(dto,tipoPersona);
        }
        return crearEntityConDatosMinimos(dto,tipoPersona);
    }


    protected Entity_Persona crearEntityConTodosLosCampos(Request_Save_DTO_Persona dto,Entity_TipoPersona tipoPersona){
        log.info("Creando Persona con todos los campos....");
        return mapper.crearEntity(dto,tipoPersona);
    }

    protected Entity_Persona crearEntityConDatosMinimos(Request_Save_DTO_Persona dto,Entity_TipoPersona tipoPersona){
        log.info("Creando Persona con los campos minimos....");
        return mapper.crearEntityCamposMinimos(dto,tipoPersona);
    }


}
