package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoEntrada.CrearCanal_PuertoEntrada;
import cl.bicevida.Canal.domain.puertoSalida.CrearCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_CrearCanal_Controlador implements CrearCanal_PuertoEntrada {

    private CrearCanal_PuertoSalida crearCanalPuertoSalida;

    public Canal_CrearCanal_Controlador(CrearCanal_PuertoSalida crearCanalPuertoSalida) {
        this.crearCanalPuertoSalida = crearCanalPuertoSalida;
    }

    @Override
    public Canal_Modelo crearCanala_PuertoEntrada(Canal_Modelo data_canal) {
        return crearCanalPuertoSalida.crearCanal_PuertoSalida(data_canal);
    }
}
