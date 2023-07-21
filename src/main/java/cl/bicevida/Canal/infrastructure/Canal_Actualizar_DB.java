package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoSalida.ActualizarCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Canal_Actualizar_DB implements ActualizarCanal_PuertoSalida {

    @Inject
    Canal_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Canal_Modelo actualizarCanal_PuertoSalida(Long id, Canal_Modelo data_canal) {
        Canal_Modelo canal_actual = repository.findById(id);
        canal_actual.setNombre(data_canal.getNombre());
        canal_actual.setActive(data_canal.getActive());
        canal_actual.setFechaCreacion(data_canal.getFechaCreacion());
        canal_actual.setFechaActualizacion(data_canal.getFechaActualizacion());
        canal_actual.setUsuarioCreacion(data_canal.getUsuarioCreacion());
        canal_actual.setUsuarioActualizacion(data_canal.getUsuarioActualizacion());
        return repository.findById(canal_actual.getId());
    }

}
