package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoEntrada.ObtenerCanal_PuertoEntrada;
import cl.bicevida.Canal.domain.puertoEntrada.ObtenerTodosCanal_PuertoEntrada;
import cl.bicevida.Canal.domain.puertoSalida.ObtenerCanal_PuertoSalida;
import cl.bicevida.Canal.domain.puertoSalida.ObtenerTodosCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Canal_ObtenerTodosCanal_Controlador implements ObtenerTodosCanal_PuertoEntrada {

    private ObtenerTodosCanal_PuertoSalida obtenerTodosCanalPuertoSalida;

    public Canal_ObtenerTodosCanal_Controlador(ObtenerTodosCanal_PuertoSalida obtenerTodosCanalPuertoSalida) {
        this.obtenerTodosCanalPuertoSalida = obtenerTodosCanalPuertoSalida;
    }

    @Override
    public List<Canal_Modelo> obtenerTodosCanal_PuertoEntrada() {
        return obtenerTodosCanalPuertoSalida.obtenerTodosCanal_PuertoSalida();
    }
}
