package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Crear_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_TipoDenucio implements PuertoSalida_Crear_TipoDenucio {

    @Inject
    PanacheRepository_TipoDenucio repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Entity_TipoDenucio crearTipoDenucio_PuertoSalida(Entity_TipoDenucio tipoDenucio) {
        repository.persist(tipoDenucio);
        return repository.findById(tipoDenucio.getId());
    }
}
