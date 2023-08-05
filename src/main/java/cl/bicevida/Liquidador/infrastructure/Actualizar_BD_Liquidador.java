package cl.bicevida.Liquidador.infrastructure;


import cl.bicevida.Liquidador.domain.DTO.Request_Update_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Actualizar_Liquidador;
import cl.bicevida.Liquidador.utils.Mapper_Liquidador;
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
public class Actualizar_BD_Liquidador implements PuertoSalida_Actualizar_Liquidador {

    private final PanacheRepository_Liquidador repository;

    private final Mapper_Liquidador mapper;

    public Actualizar_BD_Liquidador(PanacheRepository_Liquidador repository, Mapper_Liquidador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_Liquidador actualizar(Long id, Request_Update_DTO_Liquidador dto) {
        try {
            Entity_Liquidador entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));
            entity.setNombre(dto.getNombre());
            entity.setEmail(dto.getEmail());
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
            throw new InternalServerErrorException("Error al actualizar un Liquidador: " + e.getMessage());
        }

    }
}
