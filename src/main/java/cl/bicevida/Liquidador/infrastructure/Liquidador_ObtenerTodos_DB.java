package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarTodos_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class Liquidador_ObtenerTodos_DB implements PuertoSalida_BuscarTodos_Liquidador {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Entity_Liquidador> obtenerTodos_PuertaSalida() {
        return repository.listAll();
    }
}
