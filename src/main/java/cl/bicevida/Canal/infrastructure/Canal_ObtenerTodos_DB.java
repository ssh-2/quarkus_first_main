package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoSalida.ObtenerTodosCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class Canal_ObtenerTodos_DB implements ObtenerTodosCanal_PuertoSalida {

    @Inject
    Canal_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Canal_Modelo> obtenerTodosCanal_PuertoSalida() {
        return repository.listAll();
    }
}
