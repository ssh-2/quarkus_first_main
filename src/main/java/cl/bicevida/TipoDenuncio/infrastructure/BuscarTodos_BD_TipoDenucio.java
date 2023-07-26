package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoDenucio;
import cl.bicevida.TipoDenuncio.utils.Mapper_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_TipoDenucio implements PuertoSalida_BuscarTodos_TipoDenucio {

    private final PanacheRepository_TipoDenucio repository;

    private final Mapper_TipoDenucio mapper;

    public BuscarTodos_BD_TipoDenucio(PanacheRepository_TipoDenucio repository, Mapper_TipoDenucio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_TipoDenucio> buscarTodos() {
        List<Entity_TipoDenucio> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
