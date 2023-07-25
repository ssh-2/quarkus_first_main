package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_Eliminar_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Eliminar_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Liquidador implements PuertoEntrada_Eliminar_Liquidador {

    private final PuertoSalida_Eliminar_Liquidador puertoSalida;

    public Controller_Eliminar_Liquidador(PuertoSalida_Eliminar_Liquidador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
