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
import org.jboss.resteasy.spi.InternalServerErrorException;

import static cl.bicevida.Persona.utils.Persona_Constants.emailODireccionRequeridos;
import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

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
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_Persona actualizar(Long id, Request_Update_DTO_Persona dto) {
        log.info("[PUT] intentando modificar una persona con id: " + id);
        try {
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

            //Buscamos SI Existe la Persona a modificar por el ID || Generamos Error
            Entity_Persona entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException("En la tabla Persona " + NOT_FOUND_BY_ID + id));

            //Modificamos los datos
            Entity_Persona entityModificada = crearEntityDesdeDTO(dto, tipoPersona, entity);

            //Persistimos en la BD
            repository.persist(entityModificada);
            return mapper.crearDTO(entityModificada);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al actualizar una persona: " + e.getMessage());
        }
    }

    protected Entity_Persona crearEntityDesdeDTO(Request_Update_DTO_Persona dto, Entity_TipoPersona tipoPersona,Entity_Persona entity) {
        if (dto.getIdPersonaLegacy() == null) {
            return crearEntityConTodosLosCampos(dto, tipoPersona,entity);
        }
        return crearEntityConDatosMinimos(dto, tipoPersona,entity);
    }


    protected Entity_Persona crearEntityConTodosLosCampos(Request_Update_DTO_Persona dto, Entity_TipoPersona tipoPersona,Entity_Persona entity) {
        log.info("Modificando Persona con todos los campos....");
        return mapper.crearEntity(dto, tipoPersona,entity);
    }

    protected Entity_Persona crearEntityConDatosMinimos(Request_Update_DTO_Persona dto, Entity_TipoPersona tipoPersona,Entity_Persona entity) {
        log.info("Modificando Persona con los campos minimos....");
        return mapper.crearEntityCamposMinimos(dto, tipoPersona,entity);
    }
}
