package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BusacrPorID_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Canal_ObtenerCanal_DB implements PuertoSalida_BusacrPorID_Canal {
    @Inject
    PanacheRepository_Canal repository;

    @Override
    public Entity_Canal obtenerCanal_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
