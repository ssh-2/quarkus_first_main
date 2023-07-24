package cl.bicevida.TipoDenuncio.domain.modelo.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.ObtenerTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TipoDenucio_ObtenerTipoDenucio_DB implements ObtenerTipoDenucio_PuertoSalida {

    @Inject
    TipoDenucio_PanacheRepository repository;

    @Override
    public TipoDenuncio_Modelo obtenerTipoDenucio_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
