package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoEntrada.ActualizarCanal_PuertoEntrada;
import cl.bicevida.Canal.domain.puertoSalida.ActualizarCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_ActualizarCanal_Controlador implements ActualizarCanal_PuertoEntrada {

    private ActualizarCanal_PuertoSalida actualizarCanalPuertoSalida;

    public Canal_ActualizarCanal_Controlador(ActualizarCanal_PuertoSalida actualizarCanalPuertoSalida) {
        this.actualizarCanalPuertoSalida = actualizarCanalPuertoSalida;
    }

    @Override
    public Canal_Modelo actualizarCanal_PuertoEntrada(Long id, Canal_Modelo canal) {
        return actualizarCanalPuertoSalida.actualizarCanal_PuertoSalida(id, canal);
    }
}
