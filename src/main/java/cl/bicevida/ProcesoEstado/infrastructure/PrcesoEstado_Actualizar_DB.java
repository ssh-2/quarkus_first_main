package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.ActualizarProcesoEstado_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class PrcesoEstado_Actualizar_DB implements ActualizarProcesoEstado_PuertoSalida {

    @Inject
    ProcesoEstado_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public ProcesoEstado_Modelo actualizarProcesoEstado_PuertoEntrada(Long id, ProcesoEstado_Modelo data_procesoEstado) {
        ProcesoEstado_Modelo procesoEstadoActual = repository.findById(id);
        procesoEstadoActual.setNombre(data_procesoEstado.getNombre());
        procesoEstadoActual.setActive(data_procesoEstado.getActive());

        return repository.findById(procesoEstadoActual.getId());
    }
}
