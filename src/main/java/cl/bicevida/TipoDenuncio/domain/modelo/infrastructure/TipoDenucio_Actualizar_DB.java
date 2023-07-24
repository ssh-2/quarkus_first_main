package cl.bicevida.TipoDenuncio.domain.modelo.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.ActualizarTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TipoDenucio_Actualizar_DB implements ActualizarTipoDenucio_PuertoSalida {

    @Inject
    TipoDenucio_PanacheRepository repository;

    @Override
    public TipoDenuncio_Modelo actualizarTipoDenucio_PuertoSalida(Long id, TipoDenuncio_Modelo data_tipoDenucio) {

        TipoDenuncio_Modelo tipoDenucio_actual = repository.findById(id);
        tipoDenucio_actual.setNombre(data_tipoDenucio.getNombre());
        tipoDenucio_actual.setActive(data_tipoDenucio.getActive());

        return repository.findById(tipoDenucio_actual.getId());
    }
}
