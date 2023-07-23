package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.puertaSalida.EliminarProcesoEstado_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class ProcesoEstado_Eliminar_DB implements EliminarProcesoEstado_PuertoSalida {

    ProcesoEstado_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarPrcesoEstado_PuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
