package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoSalida.CrearCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Canal_Crear_DB implements CrearCanal_PuertoSalida {

    @Inject
    Canal_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Canal_Modelo crearCanal_PuertoSalida(Canal_Modelo canal) {
        repository.persist(canal);
        return repository.findById(canal.getId());
    }
}
