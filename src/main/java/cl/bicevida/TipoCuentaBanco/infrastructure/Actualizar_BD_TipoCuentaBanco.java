package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Update_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Actualizar_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.utils.Mapper_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_TipoCuentaBanco implements PuertoSalida_Actualizar_TipoCuentaBanco {

    private final PanacheRepository_TipoCuentaBanco repository;

    private final Mapper_TipoCuentaBanco mapper;

    public Actualizar_BD_TipoCuentaBanco(PanacheRepository_TipoCuentaBanco repository, Mapper_TipoCuentaBanco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Response_DTO_TipoCuentaBanco actualizar(Long id, Request_Update_DTO_TipoCuentaBanco dto) {
        try {
            Entity_TipoCuentaBanco entity = repository.findByIdOptional(id)
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
            throw new InternalServerErrorException("Error al actualizar tipo cuenta banco: " + e.getMessage());
        }

    }
}
