package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.ObtenerLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Liquidador_ObtenerLiquidador_DB implements ObtenerLiquidador_PuertoSalida {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    public Liquidador_Modelo obtenerLiquidador_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
