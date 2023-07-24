package cl.bicevida.TipoDenuncio.domain.modelo.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoEntrada.CrearTipoDenucio_PuertoEntrada;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.CrearTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDenucio_CrearTipoDenucio_Controlador implements CrearTipoDenucio_PuertoEntrada {

    private CrearTipoDenucio_PuertoSalida crearTipoDenucioPuertoSalida;

    public TipoDenucio_CrearTipoDenucio_Controlador(CrearTipoDenucio_PuertoSalida crearTipoDenucioPuertoSalida) {
        this.crearTipoDenucioPuertoSalida = crearTipoDenucioPuertoSalida;
    }

    @Override
    public TipoDenuncio_Modelo crearTipoDenucio_PuertoEntrada(TipoDenuncio_Modelo data_tipoDenucio) {
        return crearTipoDenucioPuertoSalida.crearTipoDenucio_PuertoSalida(data_tipoDenucio);
    }
}
