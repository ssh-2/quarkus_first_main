package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_TipoDenucio implements PuertoSalida_BuscarTodos_TipoDenucio {

    @Inject
    PanacheRepository_TipoDenucio repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Entity_TipoDenucio> obtenerTodosTipoDenucio_PuertoSalida() {
        return repository.listAll();
    }
}
