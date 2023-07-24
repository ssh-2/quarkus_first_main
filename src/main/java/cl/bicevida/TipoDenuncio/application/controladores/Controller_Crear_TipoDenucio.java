package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_Crear_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Crear_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_TipoDenucio implements PuertoEntrada_Crear_TipoDenucio {

    private PuertoSalida_Crear_TipoDenucio crearTipoDenucioPuertoSalida;

    public Controller_Crear_TipoDenucio(PuertoSalida_Crear_TipoDenucio crearTipoDenucioPuertoSalida) {
        this.crearTipoDenucioPuertoSalida = crearTipoDenucioPuertoSalida;
    }

    @Override
    public Entity_TipoDenucio crearTipoDenucio_PuertoEntrada(Entity_TipoDenucio data_tipoDenucio) {
        return crearTipoDenucioPuertoSalida.crearTipoDenucio_PuertoSalida(data_tipoDenucio);
    }
}
