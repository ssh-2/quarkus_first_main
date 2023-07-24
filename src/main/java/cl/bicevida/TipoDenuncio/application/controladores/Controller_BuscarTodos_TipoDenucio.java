package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_BuscarTodos_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_TipoDenucio implements PuertoEntrada_BuscarTodos_TipoDenucio {

    private PuertoSalida_BuscarTodos_TipoDenucio obtenerTodosTipoDenucioPuertoSalida;

    public Controller_BuscarTodos_TipoDenucio(PuertoSalida_BuscarTodos_TipoDenucio obtenerTodosTipoDenucioPuertoSalida) {
        this.obtenerTodosTipoDenucioPuertoSalida = obtenerTodosTipoDenucioPuertoSalida;
    }

    @Override
    public List<Entity_TipoDenucio> obtenerTodosTipoDenucio_PuertoEntrada() {
        return obtenerTodosTipoDenucioPuertoSalida.obtenerTodosTipoDenucio_PuertoSalida();
    }
}
