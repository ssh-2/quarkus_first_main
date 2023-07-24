package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarTodos_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_BuscarTodos_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_ProcesoEstado implements PuertoEntrada_BuscarTodos_ProcesoEstado {

    private PuertoSalida_BuscarTodos_ProcesoEstado obtenerTodosProcesoEstadoPuertoSalida;

    public Controller_BuscarTodos_ProcesoEstado(PuertoSalida_BuscarTodos_ProcesoEstado obtenerTodosProcesoEstadoPuertoSalida) {
        this.obtenerTodosProcesoEstadoPuertoSalida = obtenerTodosProcesoEstadoPuertoSalida;
    }

    @Override
    public List<Entity_ProcesoEstado> obtenerTodosProcesoEstado_PuertoEntrada() {
        return obtenerTodosProcesoEstadoPuertoSalida.obtenerTodosProcesoEstado_PuertoSalida();
    }
}
