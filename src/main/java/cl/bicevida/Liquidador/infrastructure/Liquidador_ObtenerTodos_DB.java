package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.ObtenerTodos_Liquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class Liquidador_ObtenerTodos_DB implements ObtenerTodos_Liquidador_PuertoSalida {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Liquidador_Modelo> obtenerTodos_PuertaSalida() {
        return repository.listAll();
    }
}
