package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_Eliminar_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Eliminar_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_TipoDenucio implements PuertoEntrada_Eliminar_TipoDenucio {

    private PuertoSalida_Eliminar_TipoDenucio puertoSalida;

    public Controller_Eliminar_TipoDenucio(PuertoSalida_Eliminar_TipoDenucio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
