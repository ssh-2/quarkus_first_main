package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.CrearTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class TipoDenucio_Crear_DB implements CrearTipoDenucio_PuertoSalida {

    @Inject
    TipoDenucio_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public TipoDenuncio_Modelo crearTipoDenucio_PuertoSalida(TipoDenuncio_Modelo tipoDenucio) {
        repository.persist(tipoDenucio);
        return repository.findById(tipoDenucio.getId());
    }
}
