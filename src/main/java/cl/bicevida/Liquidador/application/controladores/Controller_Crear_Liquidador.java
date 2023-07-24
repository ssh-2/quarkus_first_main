package cl.bicevida.Liquidador.application.controladores;


import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.CrearLiquidador_PuertoEntrada;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Crear_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_Liquidador implements CrearLiquidador_PuertoEntrada {

    private PuertoSalida_Crear_Liquidador crearLiquidadorPuertoSalida;

    public Controller_Crear_Liquidador(PuertoSalida_Crear_Liquidador crearLiquidadorPuertoSalida) {
        this.crearLiquidadorPuertoSalida = crearLiquidadorPuertoSalida;
    }

    @Override
    public Entity_Liquidador crearLiquidador_PuertoEntrada(Entity_Liquidador data_liquidador) {
        return crearLiquidadorPuertoSalida.crearLiquidador_PuertoSalida(data_liquidador);
    }
}
