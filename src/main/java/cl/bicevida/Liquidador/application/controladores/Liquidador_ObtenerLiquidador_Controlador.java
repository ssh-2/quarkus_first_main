package cl.bicevida.Liquidador.application.controladores;


import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoEntrada.ObtenerLiquidador_PuertoEntrada;
import cl.bicevida.Liquidador.domain.puertoSalida.ObtenerLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Liquidador_ObtenerLiquidador_Controlador implements ObtenerLiquidador_PuertoEntrada {

    private ObtenerLiquidador_PuertoSalida obtenerLiquidadorPuertoSalida;

    public Liquidador_ObtenerLiquidador_Controlador(ObtenerLiquidador_PuertoSalida obtenerLiquidadorPuertoSalida) {
        this.obtenerLiquidadorPuertoSalida = obtenerLiquidadorPuertoSalida;
    }

    @Override
    public Liquidador_Modelo obtenerLiquidador_PuertoEntrada(Long id) {
        return obtenerLiquidadorPuertoSalida.obtenerLiquidador_PuertoSalida(id);
    }
}
