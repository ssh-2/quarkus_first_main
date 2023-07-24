package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarTodos_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_ProcesoEstado implements PuertoSalida_BuscarTodos_ProcesoEstado {

    @Inject
    PanacheRepository_ProcesoEstado repository;

    @Override
    public List<Entity_ProcesoEstado> obtenerTodosProcesoEstado_PuertoSalida() {
        return repository.listAll();
    }
}
