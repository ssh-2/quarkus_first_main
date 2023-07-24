package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarPorID_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BusacrPorID_BD_ProcesoEstado implements PuertoSalida_BuscarPorID_ProcesoEstado {

    @Inject
    PanacheRepository_ProcesoEstado repository;

    @Override
    public Entity_ProcesoEstado obtenerProcesoEstado_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
