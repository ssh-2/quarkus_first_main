package cl.bicevida.Banco.application.controladores;

import cl.bicevida.Banco.domain.puertoEntrada.PuertoEntrada_Eliminar_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_Eliminar_Banco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Banco implements PuertoEntrada_Eliminar_Banco {

    private final PuertoSalida_Eliminar_Banco puertoSalida;

    public Controller_Eliminar_Banco(PuertoSalida_Eliminar_Banco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
