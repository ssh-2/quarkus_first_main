package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarTodos_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Liquidador implements PuertoEntrada_BuscarTodos_Liquidador {

    private PuertoSalida_BuscarTodos_Liquidador obtenerTodosLiquidadorPuertoSalida;

    public Controller_BuscarTodos_Liquidador(PuertoSalida_BuscarTodos_Liquidador obtenerTodosLiquidadorPuertoSalida) {
        this.obtenerTodosLiquidadorPuertoSalida = obtenerTodosLiquidadorPuertoSalida;
    }

    @Override
    public List<Entity_Liquidador> obtenerTodos_PuertaEntrada() {
        return obtenerTodosLiquidadorPuertoSalida.obtenerTodos_PuertaSalida();
    }
}
