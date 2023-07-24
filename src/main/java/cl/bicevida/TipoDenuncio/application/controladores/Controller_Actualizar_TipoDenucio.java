package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_Actualizar_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Actualizar_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_TipoDenucio implements PuertoEntrada_Actualizar_TipoDenucio {

    private PuertoSalida_Actualizar_TipoDenucio actualizarTipoDenucioPuertoSalida;

    public Controller_Actualizar_TipoDenucio(PuertoSalida_Actualizar_TipoDenucio actualizarTipoDenucioPuertoSalida) {
        this.actualizarTipoDenucioPuertoSalida = actualizarTipoDenucioPuertoSalida;
    }

    @Override
    public Entity_TipoDenucio actualizarTipoDenucio_PuertoEntrada(Long id, Entity_TipoDenucio tipoDenucio) {
        return actualizarTipoDenucioPuertoSalida.actualizarTipoDenucio_PuertoSalida(id, tipoDenucio);
    }
}
