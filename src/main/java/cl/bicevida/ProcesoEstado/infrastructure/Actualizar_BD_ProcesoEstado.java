package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Actualizar_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Actualizar_BD_ProcesoEstado implements PuertoSalida_Actualizar_ProcesoEstado {

    @Inject
    PanacheRepository_ProcesoEstado repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Entity_ProcesoEstado actualizarProcesoEstado_PuertoEntrada(Long id, Entity_ProcesoEstado data_procesoEstado) {
        Entity_ProcesoEstado procesoEstadoActual = repository.findById(id);
        procesoEstadoActual.setNombre(data_procesoEstado.getNombre());
        procesoEstadoActual.setActive(data_procesoEstado.getActive());

        return repository.findById(procesoEstadoActual.getId());
    }
}
