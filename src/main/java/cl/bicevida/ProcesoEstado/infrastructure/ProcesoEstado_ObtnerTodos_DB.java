package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.ObtenerTodosProcesoEstado_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProcesoEstado_ObtnerTodos_DB implements ObtenerTodosProcesoEstado_PuertoSalida {

    @Inject
    ProcesoEstado_PanacheRepository repository;

    @Override
    public List<ProcesoEstado_Modelo> obtenerTodosProcesoEstado_PuertoSalida() {
        return repository.listAll();
    }
}
