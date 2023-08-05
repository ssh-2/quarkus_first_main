package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.DTO.Request_Update_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Actualizar_Canal;
import cl.bicevida.Canal.utils.Mapper_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
public class Actualizar_BD_Canal implements PuertoSalida_Actualizar_Canal {

    private final PanacheRepository_Canal repository;

    private final Mapper_Canal mapper;

    public Actualizar_BD_Canal(PanacheRepository_Canal repository, Mapper_Canal mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_Canal actualizar(Long id, Request_Update_DTO_Canal dto) {
        try {
            Entity_Canal entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));
            entity.setNombre(dto.getNombre());
            entity.setUsuarioActualizacion(dto.getUsuarioActualizacion());
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
            throw new InternalServerErrorException("Error al actualizar un Canal: " + e.getMessage());
        }

    }
}
