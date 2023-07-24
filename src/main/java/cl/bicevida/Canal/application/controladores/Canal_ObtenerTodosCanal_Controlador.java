package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BuscarTodos_Canal;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Canal_ObtenerTodosCanal_Controlador implements PuertoEntrada_BuscarTodos_Canal {

    private PuertoSalida_BuscarTodos_Canal obtenerTodosCanalPuertoSalida;

    public Canal_ObtenerTodosCanal_Controlador(PuertoSalida_BuscarTodos_Canal obtenerTodosCanalPuertoSalida) {
        this.obtenerTodosCanalPuertoSalida = obtenerTodosCanalPuertoSalida;
    }

    @Override
    public List<Entity_Canal> obtenerTodosCanal_PuertoEntrada() {
        return obtenerTodosCanalPuertoSalida.obtenerTodosCanal_PuertoSalida();
    }
}
