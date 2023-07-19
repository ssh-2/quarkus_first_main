package cl.bicevida.Canal.infrastructure;


import cl.bicevida.Canal.domain.puertoSalida.EliminarCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Canal_Eliminar_DB implements EliminarCanal_PuertoSalida {
    @Inject
    Canal_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarCanalPuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
