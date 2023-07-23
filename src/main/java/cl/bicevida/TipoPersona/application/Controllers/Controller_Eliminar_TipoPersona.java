package cl.bicevida.TipoPersona.application.Controllers;

import cl.bicevida.TipoPersona.domain.puertoEntrada.PuertoEntrada_Eliminar_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_Eliminar_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_TipoPersona implements PuertoEntrada_Eliminar_TipoPersona {

    private final PuertoSalida_Eliminar_TipoPersona puertoSalida;

    public Controller_Eliminar_TipoPersona(PuertoSalida_Eliminar_TipoPersona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
         puertoSalida.eliminarPorID(id);
    }
}
