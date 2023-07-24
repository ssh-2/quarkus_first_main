package cl.bicevida.Canal.infrastructure;


import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Eliminar_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Eliminar_BD_Canal implements PuertoSalida_Eliminar_Canal {
    @Inject
    PanacheRepository_Canal repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarCanalPuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
