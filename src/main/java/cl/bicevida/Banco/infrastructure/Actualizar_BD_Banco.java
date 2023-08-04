package cl.bicevida.Banco.infrastructure;

import cl.bicevida.Banco.domain.DTO.Request_Update_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_Actualizar_Banco;
import cl.bicevida.Banco.utils.Mapper_Banco;
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
public class Actualizar_BD_Banco implements PuertoSalida_Actualizar_Banco {

    private final PanacheRepository_Banco repository;

    private final Mapper_Banco mapper;

    public Actualizar_BD_Banco(PanacheRepository_Banco repository, Mapper_Banco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_Banco actualizar(Long id, Request_Update_DTO_Banco dto) {
        try {
            Entity_Banco entity = repository.findByIdOptional(id)
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
            throw new InternalServerErrorException("Error al actualizar Banco: " + e.getMessage());
        }

    }
}
