package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Parentesco.domain.puertoEntrada.PuertoEntrada_Eliminar_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_Eliminar_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Parentesco implements PuertoEntrada_Eliminar_Parentesco {

    private final PuertoSalida_Eliminar_Parentesco puertoSalida;

    public Controller_Eliminar_Parentesco(PuertoSalida_Eliminar_Parentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
         puertoSalida.eliminarPorID(id);
    }
}
