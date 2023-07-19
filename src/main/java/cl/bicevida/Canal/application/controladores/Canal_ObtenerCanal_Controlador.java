package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoEntrada.ObtenerCanal_PuertoEntrada;
import cl.bicevida.Canal.domain.puertoSalida.ObtenerCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_ObtenerCanal_Controlador implements ObtenerCanal_PuertoEntrada {

    private ObtenerCanal_PuertoSalida obtenerCanalPuertoSalida;

    public Canal_ObtenerCanal_Controlador(ObtenerCanal_PuertoSalida obtenerCanalPuertoSalida) {
        this.obtenerCanalPuertoSalida = obtenerCanalPuertoSalida;
    }
    @Override
    public Canal_Modelo obtenerCanal_PuertoEntrada(Long id) {
        return obtenerCanalPuertoSalida.obtenerCanal_PuertoSalida(id);
    }
}
