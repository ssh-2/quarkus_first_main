package cl.bicevida.Persona.infraestructure;

import cl.bicevida.Persona.domain.DTO.Request_Update_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Actualizar_Persona;
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

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;
import static cl.bicevida.Utils.Constants.RUT_INVALIDO;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_Persona implements PuertoSalida_Actualizar_Persona {

    private final PanacheRepository_Persona repository;

    private final PanacheRepository_TipoPersona repositoryTipoPersona;

    private final Mapper_Persona mapper;

    private final RutValidation rutValidation;

    public Actualizar_BD_Persona(PanacheRepository_Persona repository, PanacheRepository_TipoPersona repositoryTipoPersona, Mapper_Persona mapper, RutValidation rutValidation) {
        this.repository = repository;
        this.repositoryTipoPersona = repositoryTipoPersona;
        this.mapper = mapper;
        this.rutValidation = rutValidation;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000,abortOn = {BadRequestException.class,NotFoundException.class})
    @Transactional
    public Response_DTO_Persona actualizar(Long id, Request_Update_DTO_Persona dto) {
        //Validamos El RUT
        boolean isAValidRut = rutValidation.isAValidRut(dto.getRut(),dto.dv);
        if(!isAValidRut){
            throw new BadRequestException(RUT_INVALIDO);
        }

        //Buscamos SI existe el Tipo de Persona || generamos Error
        Long idTipoPersona = Long.parseLong(dto.getId_tipo_persona());
        Entity_TipoPersona tipoPersona = repositoryTipoPersona.findByIdOptional(idTipoPersona)
                .orElseThrow(()-> new NotFoundException("En la tabla TipoPersona " + NOT_FOUND_BY_ID + idTipoPersona));

        //Buscamos SI Existe la Persona a modificar por el ID || Generamos Error
        Entity_Persona entity = repository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException("En la tabla Persona " + NOT_FOUND_BY_ID + id));

        //Modificamos los datos
        Entity_Persona entityModificada = mapper.crearEntity(dto,tipoPersona,entity);

        //Persistimos en la BD
        repository.persist(entityModificada);
        return mapper.crearDTO(entityModificada);
    }
}
