package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoSalida.ObtenerCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Canal_ObtenerCanal_DB implements ObtenerCanal_PuertoSalida {
    @Inject
    Canal_PanacheRepository repository;

    @Override
    public Canal_Modelo obtenerCanal_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
