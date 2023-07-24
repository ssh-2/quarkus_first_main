package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_Actualizar_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Actualizar_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_ActualizarCanal_Controlador implements PuertoEntrada_Actualizar_Canal {

    private PuertoSalida_Actualizar_Canal actualizarCanalPuertoSalida;

    public Canal_ActualizarCanal_Controlador(PuertoSalida_Actualizar_Canal actualizarCanalPuertoSalida) {
        this.actualizarCanalPuertoSalida = actualizarCanalPuertoSalida;
    }

    @Override
    public Entity_Canal actualizarCanal_PuertoEntrada(Long id, Entity_Canal canal) {
        return actualizarCanalPuertoSalida.actualizarCanal_PuertoSalida(id, canal);
    }
}
