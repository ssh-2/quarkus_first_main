package cl.bicevida.Persona.application.Controllers;

import cl.bicevida.Persona.domain.puertoEntrada.PuertoEntrada_Eliminar_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Eliminar_Persona;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Persona implements PuertoEntrada_Eliminar_Persona {

    private final PuertoSalida_Eliminar_Persona puertoSalida;

    public Controller_Eliminar_Persona(PuertoSalida_Eliminar_Persona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
         puertoSalida.eliminarPorID(id);
    }
}
