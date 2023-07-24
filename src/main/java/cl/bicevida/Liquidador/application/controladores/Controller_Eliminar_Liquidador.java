package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_Eliminar_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Eliminar_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Liquidador implements PuertoEntrada_Eliminar_Liquidador {

    private PuertoSalida_Eliminar_Liquidador eliminarLiquidadorPuertoSalida;

    public Controller_Eliminar_Liquidador(PuertoSalida_Eliminar_Liquidador eliminarLiquidadorPuertoSalida) {
        this.eliminarLiquidadorPuertoSalida = eliminarLiquidadorPuertoSalida;
    }

    @Override
    public void eliminarLiquidador_PuertoEntrada(Long id) {
        eliminarLiquidadorPuertoSalida.eliminarLiquidador_PuertoSalida(id);
    }
}
