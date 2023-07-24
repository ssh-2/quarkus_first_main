package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BuscarTodos_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Canal implements PuertoSalida_BuscarTodos_Canal {

    @Inject
    PanacheRepository_Canal repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Entity_Canal> obtenerTodosCanal_PuertoSalida() {
        return repository.listAll();
    }
}
