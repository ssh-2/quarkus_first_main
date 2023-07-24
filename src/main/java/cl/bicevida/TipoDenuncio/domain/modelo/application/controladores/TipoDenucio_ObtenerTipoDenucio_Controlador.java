package cl.bicevida.TipoDenuncio.domain.modelo.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoEntrada.ObtenerTipoDenucio_PuertoEntrada;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.ObtenerTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDenucio_ObtenerTipoDenucio_Controlador implements ObtenerTipoDenucio_PuertoEntrada {

    private ObtenerTipoDenucio_PuertoSalida obtenerTipoDenucioPuertoSalida;

    public TipoDenucio_ObtenerTipoDenucio_Controlador(ObtenerTipoDenucio_PuertoSalida obtenerTipoDenucioPuertoSalida) {
        this.obtenerTipoDenucioPuertoSalida = obtenerTipoDenucioPuertoSalida;
    }

    @Override
    public TipoDenuncio_Modelo obtenerTipoDenucio_PuertoEntrada(Long id) {
        return obtenerTipoDenucioPuertoSalida.obtenerTipoDenucio_PuertoSalida(id);
    }
}
