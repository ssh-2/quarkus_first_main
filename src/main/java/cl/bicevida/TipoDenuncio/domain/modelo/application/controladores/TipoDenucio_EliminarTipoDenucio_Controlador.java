package cl.bicevida.TipoDenuncio.domain.modelo.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoEntrada.EliminarTipoDenucio_PuertoEntrada;
import cl.bicevida.TipoDenuncio.domain.modelo.domain.puertoSalida.EliminarTipoDenucio_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDenucio_EliminarTipoDenucio_Controlador implements EliminarTipoDenucio_PuertoEntrada {

    private EliminarTipoDenucio_PuertoSalida eliminarTipoDenucioPuertoSalida;

    public TipoDenucio_EliminarTipoDenucio_Controlador(EliminarTipoDenucio_PuertoSalida eliminarTipoDenucioPuertoSalida) {
        this.eliminarTipoDenucioPuertoSalida = eliminarTipoDenucioPuertoSalida;
    }

    @Override
    public void eliminarTipoDenucio_PuertoEntrada(Long id) {
        eliminarTipoDenucioPuertoSalida.eliminarTipoDenucio_PuertoSalida(id);
    }
}
