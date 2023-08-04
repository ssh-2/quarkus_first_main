package cl.bicevida.TipoParentesco.infraestructure;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Update_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_Actualizar_TipoParentesco;
import cl.bicevida.TipoParentesco.utils.Mapper_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.LocalDateTime;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_TipoParentesco implements PuertoSalida_Actualizar_TipoParentesco {

    private final PanacheRepository_TipoParentesco repository;

    private final Mapper_TipoParentesco mapper;

    public Actualizar_BD_TipoParentesco(PanacheRepository_TipoParentesco repository, Mapper_TipoParentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_TipoParentesco actualizar(Long id, Request_Update_DTO_TipoParentesco dto) {
        try {
            Entity_TipoParentesco entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));
            entity.setNombre(dto.getNombre().trim());
            entity.setUsuarioActualizacion(dto.getUsuarioActualizacion().trim());
            entity.setFechaActualizacion(LocalDateTime.now());
            repository.persist(entity);
            return mapper.crearDTO(entity);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al actualizar tipo parentesco: " + e.getMessage());
        }

    }
}
