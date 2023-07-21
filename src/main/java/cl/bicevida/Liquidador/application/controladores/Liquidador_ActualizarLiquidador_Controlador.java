package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoEntrada.ActualizarLiquidador_PuertoEntrada;
import cl.bicevida.Liquidador.domain.puertoSalida.ActualizarLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Liquidador_ActualizarLiquidador_Controlador implements ActualizarLiquidador_PuertoEntrada {

    private ActualizarLiquidador_PuertoSalida actualizarLiquidadorPuertoSalida;

    public Liquidador_ActualizarLiquidador_Controlador(ActualizarLiquidador_PuertoSalida actualizarLiquidadorPuertoSalida) {
        this.actualizarLiquidadorPuertoSalida = actualizarLiquidadorPuertoSalida;
    }

    @Override
    public Liquidador_Modelo actualizarLiquidador_PuertoEntrada(Long id, Liquidador_Modelo liquidador) {
        return actualizarLiquidadorPuertoSalida.actualizarLiquidador_PuertoSalida(id, liquidador);
    }
}
