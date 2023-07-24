package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BusacrPorID_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_ObtenerCanal_Controlador implements PuertoEntrada_BuscarPorID_Canal {

    private PuertoSalida_BusacrPorID_Canal obtenerCanalPuertoSalida;

    public Canal_ObtenerCanal_Controlador(PuertoSalida_BusacrPorID_Canal obtenerCanalPuertoSalida) {
        this.obtenerCanalPuertoSalida = obtenerCanalPuertoSalida;
    }
    @Override
    public Entity_Canal obtenerCanal_PuertoEntrada(Long id) {
        return obtenerCanalPuertoSalida.obtenerCanal_PuertoSalida(id);
    }
}
