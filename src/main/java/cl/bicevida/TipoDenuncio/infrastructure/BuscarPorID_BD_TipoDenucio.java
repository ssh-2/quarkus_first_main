package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BuscarPorID_BD_TipoDenucio implements PuertoSalida_BuscarPorID_TipoDenucio {

    @Inject
    PanacheRepository_TipoDenucio repository;

    @Override
    public Entity_TipoDenucio obtenerTipoDenucio_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
