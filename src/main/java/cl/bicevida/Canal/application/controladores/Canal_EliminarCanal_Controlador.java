package cl.bicevida.Canal.application.controladores;


import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_Eliminar_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Eliminar_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_EliminarCanal_Controlador implements PuertoEntrada_Eliminar_Canal {

    private PuertoSalida_Eliminar_Canal eliminarCanalPuertoSalida;

    public Canal_EliminarCanal_Controlador(PuertoSalida_Eliminar_Canal eliminarCanalPuertoSalida) {
        this.eliminarCanalPuertoSalida = eliminarCanalPuertoSalida;
    }

    @Override
    public void eliminarCanal_PuertoEntrada(Long id) {
        eliminarCanalPuertoSalida.eliminarCanalPuertoSalida(id);
    }
}
