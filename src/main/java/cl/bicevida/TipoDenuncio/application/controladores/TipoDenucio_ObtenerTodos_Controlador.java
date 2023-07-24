package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.ObtenerTodosTipoDenucio_PuertoEntrada;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.ObtenerTodosTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TipoDenucio_ObtenerTodos_Controlador implements ObtenerTodosTipoDenucio_PuertoEntrada {

    private ObtenerTodosTipoDenucio_PuertoSalida obtenerTodosTipoDenucioPuertoSalida;

    public TipoDenucio_ObtenerTodos_Controlador(ObtenerTodosTipoDenucio_PuertoSalida obtenerTodosTipoDenucioPuertoSalida) {
        this.obtenerTodosTipoDenucioPuertoSalida = obtenerTodosTipoDenucioPuertoSalida;
    }

    @Override
    public List<TipoDenuncio_Modelo> obtenerTodosTipoDenucio_PuertoEntrada() {
        return obtenerTodosTipoDenucioPuertoSalida.obtenerTodosTipoDenucio_PuertoSalida();
    }
}
