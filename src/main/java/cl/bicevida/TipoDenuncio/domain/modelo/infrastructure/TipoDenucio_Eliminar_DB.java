package cl.bicevida.TipoDenuncio.domain.modelo.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.EliminarTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class TipoDenucio_Eliminar_DB implements EliminarTipoDenucio_PuertoSalida {

    @Inject
    TipoDenucio_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarTipoDenucio_PuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
