package cl.bicevida.Liquidador.infrastructure;


import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.ActualizarLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Liquidador_Actualizar_DB implements ActualizarLiquidador_PuertoSalida {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Liquidador_Modelo actualizarLiquidador_PuertoSalida(Long id, Liquidador_Modelo data_liquidador) {
        Liquidador_Modelo liquidador_actual = repository.findById(id);
        liquidador_actual.setNombre(data_liquidador.getNombre());
        liquidador_actual.setEmail(data_liquidador.getEmail());
        liquidador_actual.setActive(data_liquidador.getActive());
        liquidador_actual.setFechaCreacion(data_liquidador.getFechaCreacion());
        liquidador_actual.setFechaActualizacion(data_liquidador.getFechaActualizacion());
        liquidador_actual.setUsuarioCreacion(data_liquidador.getUsuarioCreacion());
        liquidador_actual.setUsuarioActualizacion(data_liquidador.getUsuarioActualizacion());
        return repository.findById(liquidador_actual.getId());
    }
}
