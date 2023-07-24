package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarPorID_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Liquidador_ObtenerLiquidador_DB implements PuertoSalida_BuscarPorID_Liquidador {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    public Entity_Liquidador obtenerLiquidador_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
