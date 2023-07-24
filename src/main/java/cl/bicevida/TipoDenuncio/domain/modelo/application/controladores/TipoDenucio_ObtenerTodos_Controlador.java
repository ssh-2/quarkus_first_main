package cl.bicevida.TipoDenuncio.domain.modelo.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoEntrada.ObtenerTodosTipoDenucio_PuertoEntrada;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.ObtenerTipoDenucio_PuertoSalida;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.ObtenerTodosTipoDenucio_PuertoSalida;
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
