package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoEntrada.ObtenerTodos_Liquidador_PuertoEntrada;
import cl.bicevida.Liquidador.domain.puertoSalida.ObtenerLiquidador_PuertoSalida;
import cl.bicevida.Liquidador.domain.puertoSalida.ObtenerTodos_Liquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Liquidador_ObtenerTodos_Controlador implements ObtenerTodos_Liquidador_PuertoEntrada {

    private ObtenerTodos_Liquidador_PuertoSalida obtenerTodosLiquidadorPuertoSalida;

    public Liquidador_ObtenerTodos_Controlador(ObtenerTodos_Liquidador_PuertoSalida obtenerTodosLiquidadorPuertoSalida) {
        this.obtenerTodosLiquidadorPuertoSalida = obtenerTodosLiquidadorPuertoSalida;
    }

    @Override
    public List<Liquidador_Modelo> obtenerTodos_PuertaEntrada() {
        return obtenerTodosLiquidadorPuertoSalida.obtenerTodos_PuertaSalida();
    }
}
