package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Update_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Actualizar_TipoDenucio;
import cl.bicevida.TipoDenuncio.utils.Mapper_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.LocalDateTime;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
public class Actualizar_BD_TipoDenucio implements PuertoSalida_Actualizar_TipoDenucio {

    private final PanacheRepository_TipoDenucio repository;

    private final Mapper_TipoDenucio mapper;

    public Actualizar_BD_TipoDenucio(PanacheRepository_TipoDenucio repository, Mapper_TipoDenucio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_TipoDenucio actualizar(Long id, Request_Update_DTO_TipoDenucio dto) {
        Entity_TipoDenucio entity = repository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
        entity.setNombre(dto.getNombre());
        entity.setUsuarioActualizacion(dto.getUsuarioActualizacion());
        entity.setFechaActualizacion(LocalDateTime.now());
        repository.persist(entity);

        return mapper.crearDTO(entity);
    }
}
