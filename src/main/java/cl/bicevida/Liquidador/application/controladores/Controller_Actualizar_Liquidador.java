package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_Actualizar_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Actualizar_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Liquidador implements PuertoEntrada_Actualizar_Liquidador {

    private PuertoSalida_Actualizar_Liquidador actualizarLiquidadorPuertoSalida;

    public Controller_Actualizar_Liquidador(PuertoSalida_Actualizar_Liquidador actualizarLiquidadorPuertoSalida) {
        this.actualizarLiquidadorPuertoSalida = actualizarLiquidadorPuertoSalida;
    }

    @Override
    public Entity_Liquidador actualizarLiquidador_PuertoEntrada(Long id, Entity_Liquidador liquidador) {
        return actualizarLiquidadorPuertoSalida.actualizarLiquidador_PuertoSalida(id, liquidador);
    }
}
