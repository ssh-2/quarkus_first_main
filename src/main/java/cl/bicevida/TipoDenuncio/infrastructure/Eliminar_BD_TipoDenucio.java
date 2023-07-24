package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Eliminar_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Eliminar_BD_TipoDenucio implements PuertoSalida_Eliminar_TipoDenucio {

    @Inject
    PanacheRepository_TipoDenucio repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarTipoDenucio_PuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
