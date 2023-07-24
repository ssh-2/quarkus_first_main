package cl.bicevida.Canal.application.controladores;


import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_Eliminar_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Eliminar_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Canal implements PuertoEntrada_Eliminar_Canal {

    private final PuertoSalida_Eliminar_Canal puertoSalida;

    public Controller_Eliminar_Canal(PuertoSalida_Eliminar_Canal puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
