package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_Eliminar_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Eliminar_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_TipoDenucio implements PuertoEntrada_Eliminar_TipoDenucio {

    private PuertoSalida_Eliminar_TipoDenucio eliminarTipoDenucioPuertoSalida;

    public Controller_Eliminar_TipoDenucio(PuertoSalida_Eliminar_TipoDenucio eliminarTipoDenucioPuertoSalida) {
        this.eliminarTipoDenucioPuertoSalida = eliminarTipoDenucioPuertoSalida;
    }

    @Override
    public void eliminarTipoDenucio_PuertoEntrada(Long id) {
        eliminarTipoDenucioPuertoSalida.eliminarTipoDenucio_PuertoSalida(id);
    }
}
