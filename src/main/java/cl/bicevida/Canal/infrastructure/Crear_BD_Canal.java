package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Crear_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_Canal implements PuertoSalida_Crear_Canal {

    @Inject
    PanacheRepository_Canal repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Entity_Canal crearCanal_PuertoSalida(Entity_Canal canal) {
        repository.persist(canal);
        return repository.findById(canal.getId());
    }
}
