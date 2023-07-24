package cl.bicevida.TipoDenuncio.domain.modelo.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.ObtenerTodosTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class TipoDenucio_ObtenerTodos_DB implements ObtenerTodosTipoDenucio_PuertoSalida {

    @Inject
    TipoDenucio_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<TipoDenuncio_Modelo> obtenerTodosTipoDenucio_PuertoSalida() {
        return repository.listAll();
    }
}
