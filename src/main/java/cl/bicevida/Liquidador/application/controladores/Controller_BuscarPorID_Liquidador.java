package cl.bicevida.Liquidador.application.controladores;


import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_BuscarPorID_iquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarPorID_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_Liquidador implements PuertoEntrada_BuscarPorID_iquidador {

    private PuertoSalida_BuscarPorID_Liquidador obtenerLiquidadorPuertoSalida;

    public Controller_BuscarPorID_Liquidador(PuertoSalida_BuscarPorID_Liquidador obtenerLiquidadorPuertoSalida) {
        this.obtenerLiquidadorPuertoSalida = obtenerLiquidadorPuertoSalida;
    }

    @Override
    public Entity_Liquidador obtenerLiquidador_PuertoEntrada(Long id) {
        return obtenerLiquidadorPuertoSalida.obtenerLiquidador_PuertoSalida(id);
    }
}
