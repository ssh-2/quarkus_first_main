package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.puertoEntrada.EliminarLiquidador_PuertoEntrada;
import cl.bicevida.Liquidador.domain.puertoSalida.EliminarLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Liquidador_EliminarLiquidador_Controlador implements EliminarLiquidador_PuertoEntrada {

    private EliminarLiquidador_PuertoSalida eliminarLiquidadorPuertoSalida;

    public Liquidador_EliminarLiquidador_Controlador(EliminarLiquidador_PuertoSalida eliminarLiquidadorPuertoSalida) {
        this.eliminarLiquidadorPuertoSalida = eliminarLiquidadorPuertoSalida;
    }

    @Override
    public void eliminarLiquidador_PuertoEntrada(Long id) {
        eliminarLiquidadorPuertoSalida.eliminarLiquidador_PuertoSalida(id);
    }
}
