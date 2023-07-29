package cl.bicevida.TipoConsulta.infrastructure;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Update_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.modelo.Entity_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_Actualizar_TipoConsulta;
import cl.bicevida.TipoConsulta.utils.Mapper_TipoConsulta;
import cl.bicevida.TipoDenuncio.domain.DTO.Request_Update_DTO_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.LocalDateTime;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_TipoConsulta implements PuertoSalida_Actualizar_TipoConsulta {

    private final PanacheRepository_TipoConsulta repository;

    private final Mapper_TipoConsulta mapper;

    public Actualizar_BD_TipoConsulta(PanacheRepository_TipoConsulta repository, Mapper_TipoConsulta mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_TipoConsulta actualizar(Long id, Request_Update_DTO_TipoConsulta dto) {
        Entity_TipoConsulta entity = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));
        entity.setNombre(dto.getNombre().trim());
        entity.setUsuarioActualizacion(dto.getUsuarioActualizacion().trim());
        entity.setFechaActualizacion(LocalDateTime.now());
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
