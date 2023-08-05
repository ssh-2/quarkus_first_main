package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.utils.Mapper_Parentesco;
import cl.bicevida.Persona.domain.DTO.Request_Save_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Crear_Persona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import cl.bicevida.TipoPersona.infraestructure.PanacheRepository_TipoPersona;
import cl.bicevida.Utils.RutValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.jboss.resteasy.spi.InternalServerErrorException;

import static cl.bicevida.Persona.utils.Persona_Constants.emailODireccionRequeridos;
import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Crear_BD_Persona implements PuertoSalida_Crear_Persona {

    private final PanacheRepository_Persona repositoryPersona;

    private final PanacheRepository_TipoPersona repositoryTipoPersona;

    private final Mapper_Parentesco mapper;

    private final RutValidation rutValidation;

    public Crear_BD_Persona(PanacheRepository_Persona repositoryPersona, PanacheRepository_TipoPersona repositoryTipoPersona, Mapper_Parentesco mapper, RutValidation rutValidation) {
        this.repositoryPersona = repositoryPersona;
        this.repositoryTipoPersona = repositoryTipoPersona;
        this.mapper = mapper;
        this.rutValidation = rutValidation;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Override
    public Response_DTO_Persona crear(Request_Save_DTO_Persona dto) {
        log.info("[POST] intentando crear una persona");

        try {
            //Buscamos si existe una persona con ese rut o pasaporte, si existe generamos error
            Entity_Persona enBD = repositoryPersona.consultarPorRut(dto.getRut());
            if (enBD != null) {
                log.info("El rut ingresado ya esta registrado");
                throw new BadRequestException(dto.getRut()  + " ya esta registrado en la BD");
            }

            //Validamos que venga o el Email o la direccion
            if (dto.getEmail() == null && dto.getDireccion() == null) {
                throw new BadRequestException(emailODireccionRequeridos);
            }

            //SI es rut Chileno lo validamos
            if(dto.getEsRutChileno()){
                //Validamos q el RUT sea valido, si no es valido genera error
                rutValidation.isAValidRut(dto.getRut(), dto.getDv());
            }

            //Buscamos SI existe el Tipo de Persona || generamos Error
            Long idTipoPersona = Long.parseLong(dto.getId_tipo_persona());
            Entity_TipoPersona tipoPersona = repositoryTipoPersona.findByIdOptional(idTipoPersona)
                    .orElseThrow(() -> new NotFoundException("En la tabla TipoPersona " + NOT_FOUND_BY_ID + idTipoPersona));


            //Creamos el entity desde el DTO
            Entity_Persona entity = crearEntityDesdeDTO(dto, tipoPersona);

            //Persistimos en la BD
            repositoryPersona.persist(entity);

            //Retornamos
            return mapper.crearDTO(entity);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al crear una persona: " + e.getMessage());
        }

    }

    protected Entity_Persona crearEntityDesdeDTO(Request_Save_DTO_Persona dto, Entity_TipoPersona tipoPersona) {
        if (dto.getIdPersonaLegacy() == null) {
            return crearEntityConTodosLosCampos(dto, tipoPersona);
        }
        return crearEntityConDatosMinimos(dto, tipoPersona);
    }


    protected Entity_Persona crearEntityConTodosLosCampos(Request_Save_DTO_Persona dto, Entity_TipoPersona tipoPersona) {
        log.info("Creando Persona con todos los campos....");
        return mapper.crearEntity(dto, tipoPersona);
    }

    protected Entity_Persona crearEntityConDatosMinimos(Request_Save_DTO_Persona dto, Entity_TipoPersona tipoPersona) {
        log.info("Creando Persona con los campos minimos....");
        return mapper.crearEntityCamposMinimos(dto, tipoPersona);
    }


}
