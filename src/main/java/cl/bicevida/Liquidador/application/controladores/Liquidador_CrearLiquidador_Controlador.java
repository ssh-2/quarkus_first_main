package cl.bicevida.Liquidador.application.controladores;


import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoEntrada.CrearLiquidador_PuertoEntrada;
import cl.bicevida.Liquidador.domain.puertoSalida.CrearLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Liquidador_CrearLiquidador_Controlador implements CrearLiquidador_PuertoEntrada {

    private CrearLiquidador_PuertoSalida crearLiquidadorPuertoSalida;

    public Liquidador_CrearLiquidador_Controlador(CrearLiquidador_PuertoSalida crearLiquidadorPuertoSalida) {
        this.crearLiquidadorPuertoSalida = crearLiquidadorPuertoSalida;
    }

    @Override
    public Liquidador_Modelo crearLiquidador_PuertoEntrada(Liquidador_Modelo data_liquidador) {
        return crearLiquidadorPuertoSalida.crearLiquidador_PuertoSalida(data_liquidador);
    }
}
