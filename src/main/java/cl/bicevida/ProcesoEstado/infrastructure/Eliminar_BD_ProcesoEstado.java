package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Eliminar_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Eliminar_BD_ProcesoEstado implements PuertoSalida_Eliminar_ProcesoEstado {

    PanacheRepository_ProcesoEstado repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarPrcesoEstado_PuertoSalida(Long id) {
        repository.deleteById(id);
    }
}
