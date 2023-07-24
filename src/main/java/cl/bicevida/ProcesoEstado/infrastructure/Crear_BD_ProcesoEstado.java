package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Crear_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Crear_BD_ProcesoEstado implements PuertoSalida_Crear_ProcesoEstado {

    @Inject
    PanacheRepository_ProcesoEstado repository;

    @Override
    public Entity_ProcesoEstado crearProcesoEstado_PuertoSalida(Entity_ProcesoEstado procesoEstado) {
        repository.persist(procesoEstado);
        return repository.findById(procesoEstado.getId());
    }
}
