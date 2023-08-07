package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.domain.DTO.Request_Update_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.modelo.Entity_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_Actualizar_Parentesco;
import cl.bicevida.Parentesco.utils.Mapper_Parentesco;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.infraestructure.PanacheRepository_Persona;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.infraestructure.PanacheRepository_TipoParentesco;
import cl.bicevida.Utils.AppStringUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.jboss.resteasy.spi.InternalServerErrorException;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_Parentesco implements PuertoSalida_Actualizar_Parentesco {

    private final PanacheRepository_Parentesco repository;

    private final PanacheRepository_TipoParentesco repositoryTipoParentesco;

    private final Mapper_Parentesco mapper;

    private final String TABLE_NAME = "parentesco ";
    private final String TABLE_PERSONA = "persona ";

    private final String TABLE_TIPO_PARENTESCO = "TipoParentesco ";

    private final PanacheRepository_Persona personaRepository;

    private final AppStringUtils appStringUtils;


    public Actualizar_BD_Parentesco(PanacheRepository_Parentesco repository, PanacheRepository_TipoParentesco repositoryTipoParentesco, Mapper_Parentesco mapper, PanacheRepository_Persona personaRepository, AppStringUtils appStringUtils) {
        this.repository = repository;
        this.repositoryTipoParentesco = repositoryTipoParentesco;
        this.mapper = mapper;
        this.personaRepository = personaRepository;
        this.appStringUtils = appStringUtils;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_Parentesco actualizar(Long id, Request_Update_DTO_Parentesco dto) {
        log.info("[PUT] intentando modificar una relacion entre personas");
        try {
            //Buscar si existe la entity a modificar
            Entity_Parentesco entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException("En la tabla " + TABLE_NAME + NOT_FOUND_BY_ID + id));

            //Buscar si existe la persona
            Long idPersona = appStringUtils.transformarStringALong(dto.getIdPersona());
            Entity_Persona persona = personaRepository.findByIdOptional(idPersona)
                    .orElseThrow(() -> new NotFoundException("En la tabla " + TABLE_PERSONA + NOT_FOUND_BY_ID + idPersona));

            //Buscar si existe el pariente
            Long idPariente = appStringUtils.transformarStringALong(dto.getIdPariente());
            Entity_Persona pariente = personaRepository.findByIdOptional(idPariente)
                    .orElseThrow(() -> new NotFoundException("En la tabla " + TABLE_PERSONA + NOT_FOUND_BY_ID + idPariente));

            //Buscar si existe el tipo de relacion
            Long idTipoParentesco = appStringUtils.transformarStringALong(dto.getIdTipoParentesco());
            Entity_TipoParentesco tipoParentesco = repositoryTipoParentesco.findByIdOptional(idTipoParentesco)
                    .orElseThrow(() -> new NotFoundException("En la tabla " + TABLE_TIPO_PARENTESCO + NOT_FOUND_BY_ID + idTipoParentesco));


            //Seteamos los nuevos datos a la entity
            Entity_Parentesco entityModificada = mapper.crearEntity(
                    entity,
                    persona,
                    pariente,
                    tipoParentesco,
                    getVigente(dto),
                    getParticipacion(dto),
                    getComentario(dto),
                    dto.getUsuarioActualizacion()
            );

            //Persistimos en la BD
            repository.persist(entityModificada);

            //Creamos el DTO de salida
            return mapper.crearDTO(entityModificada);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al actualizar una relacion: " + e.getMessage());
        }
    }

    private Boolean getVigente(Request_Update_DTO_Parentesco dto) {
        if (dto.getVigente() == null) {
            return true;
        }
        return dto.getVigente();
    }

    private String getComentario(Request_Update_DTO_Parentesco dto) {
        if (dto.getComentario() == null) {
            return "";
        }
        return dto.getComentario();
    }

    private Double getParticipacion(Request_Update_DTO_Parentesco dto) {
        if (dto.getParticipacion() == null) {
            return 0D;
        }
        return appStringUtils.transformarStringADouble(dto.getParticipacion());

    }

}
