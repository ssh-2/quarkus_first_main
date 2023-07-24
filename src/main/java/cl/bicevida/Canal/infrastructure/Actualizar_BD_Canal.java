package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Actualizar_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Actualizar_BD_Canal implements PuertoSalida_Actualizar_Canal {

    @Inject
    PanacheRepository_Canal repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Entity_Canal actualizarCanal_PuertoSalida(Long id, Entity_Canal data_canal) {
        Entity_Canal canal_actual = repository.findById(id);
        canal_actual.setNombre(data_canal.getNombre());
        canal_actual.setActive(data_canal.getActive());
        canal_actual.setFechaCreacion(data_canal.getFechaCreacion());
        canal_actual.setFechaActualizacion(data_canal.getFechaActualizacion());
        canal_actual.setUsuarioCreacion(data_canal.getUsuarioCreacion());
        canal_actual.setUsuarioActualizacion(data_canal.getUsuarioActualizacion());
        return repository.findById(canal_actual.getId());
    }

}
