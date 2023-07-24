package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_BuscarPorID_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_TipoDenucio implements PuertoEntrada_BuscarPorID_TipoDenucio {

    private PuertoSalida_BuscarPorID_TipoDenucio obtenerTipoDenucioPuertoSalida;

    public Controller_BuscarPorID_TipoDenucio(PuertoSalida_BuscarPorID_TipoDenucio obtenerTipoDenucioPuertoSalida) {
        this.obtenerTipoDenucioPuertoSalida = obtenerTipoDenucioPuertoSalida;
    }

    @Override
    public Entity_TipoDenucio obtenerTipoDenucio_PuertoEntrada(Long id) {
        return obtenerTipoDenucioPuertoSalida.obtenerTipoDenucio_PuertoSalida(id);
    }
}
