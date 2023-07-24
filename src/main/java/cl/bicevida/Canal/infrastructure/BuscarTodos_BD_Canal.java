package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BuscarTodos_Canal;
import cl.bicevida.Canal.utils.Mapper_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Canal implements PuertoSalida_BuscarTodos_Canal {

    private final PanacheRepository_Canal repository;

    private final Mapper_Canal mapper;

    public BuscarTodos_BD_Canal(PanacheRepository_Canal repository, Mapper_Canal mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_Canal> buscarTodos() {
        List<Entity_Canal> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
