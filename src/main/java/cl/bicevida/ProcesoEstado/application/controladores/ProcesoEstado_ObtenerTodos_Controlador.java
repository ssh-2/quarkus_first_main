package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.ObtenerTodosProcesoEstado_PuertoSalida;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.ObtenerTodosProcesoEstado_PuertoEntrada;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProcesoEstado_ObtenerTodos_Controlador implements ObtenerTodosProcesoEstado_PuertoEntrada {

    private ObtenerTodosProcesoEstado_PuertoSalida obtenerTodosProcesoEstadoPuertoSalida;

    public ProcesoEstado_ObtenerTodos_Controlador(ObtenerTodosProcesoEstado_PuertoSalida obtenerTodosProcesoEstadoPuertoSalida) {
        this.obtenerTodosProcesoEstadoPuertoSalida = obtenerTodosProcesoEstadoPuertoSalida;
    }

    @Override
    public List<ProcesoEstado_Modelo> obtenerTodosProcesoEstado_PuertoEntrada() {
        return obtenerTodosProcesoEstadoPuertoSalida.obtenerTodosProcesoEstado_PuertoSalida();
    }
}
