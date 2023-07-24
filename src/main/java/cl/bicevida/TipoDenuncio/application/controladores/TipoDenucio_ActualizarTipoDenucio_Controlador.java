package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.ActualizarTipoDenucio_PuertoEntrada;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.ActualizarTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDenucio_ActualizarTipoDenucio_Controlador implements ActualizarTipoDenucio_PuertoEntrada {

    private ActualizarTipoDenucio_PuertoSalida actualizarTipoDenucioPuertoSalida;

    public TipoDenucio_ActualizarTipoDenucio_Controlador(ActualizarTipoDenucio_PuertoSalida actualizarTipoDenucioPuertoSalida) {
        this.actualizarTipoDenucioPuertoSalida = actualizarTipoDenucioPuertoSalida;
    }

    @Override
    public TipoDenuncio_Modelo actualizarTipoDenucio_PuertoEntrada(Long id, TipoDenuncio_Modelo tipoDenucio) {
        return actualizarTipoDenucioPuertoSalida.actualizarTipoDenucio_PuertoSalida(id, tipoDenucio);
    }
}
