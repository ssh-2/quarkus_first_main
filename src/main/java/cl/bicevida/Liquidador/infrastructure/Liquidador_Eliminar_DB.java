package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.puertoSalida.EliminarLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Liquidador_Eliminar_DB implements EliminarLiquidador_PuertoSalida {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarLiquidador_PuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
