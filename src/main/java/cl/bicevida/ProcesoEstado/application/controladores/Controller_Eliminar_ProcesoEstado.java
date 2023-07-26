package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Eliminar_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_Eliminar_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_ProcesoEstado implements PuertoEntrada_Eliminar_ProcesoEstado {

    private PuertoSalida_Eliminar_ProcesoEstado puertoSalida;

    public Controller_Eliminar_ProcesoEstado(PuertoSalida_Eliminar_ProcesoEstado puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
