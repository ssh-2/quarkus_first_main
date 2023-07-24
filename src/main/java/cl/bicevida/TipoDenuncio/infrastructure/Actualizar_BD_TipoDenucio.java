package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Actualizar_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Actualizar_BD_TipoDenucio implements PuertoSalida_Actualizar_TipoDenucio {

    @Inject
    PanacheRepository_TipoDenucio repository;

    @Override
    public Entity_TipoDenucio actualizarTipoDenucio_PuertoSalida(Long id, Entity_TipoDenucio data_tipoDenucio) {

        Entity_TipoDenucio tipoDenucio_actual = repository.findById(id);
        tipoDenucio_actual.setNombre(data_tipoDenucio.getNombre());
        tipoDenucio_actual.setActive(data_tipoDenucio.getActive());

        return repository.findById(tipoDenucio_actual.getId());
    }
}
