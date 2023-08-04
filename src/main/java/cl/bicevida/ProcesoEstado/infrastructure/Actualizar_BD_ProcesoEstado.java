package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Update_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Actualizar_ProcesoEstado;
import cl.bicevida.ProcesoEstado.utils.Mapper_ProcesoEstado;
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
public class Actualizar_BD_ProcesoEstado implements PuertoSalida_Actualizar_ProcesoEstado {

   private final PanacheRepository_ProcesoEstado repository;

   private final Mapper_ProcesoEstado mapper;

   public Actualizar_BD_ProcesoEstado(PanacheRepository_ProcesoEstado repository, Mapper_ProcesoEstado mapper) {
       this.repository = repository;
       this.mapper = mapper;
   }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_ProcesoEstado actualizar(Long id, Request_Update_DTO_ProcesoEstado dto) {
       try {
           Entity_ProcesoEstado entity = repository.findByIdOptional(id)
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
           throw new InternalServerErrorException("Error al actualizar proceso estado: " + e.getMessage());
       }

    }
}
