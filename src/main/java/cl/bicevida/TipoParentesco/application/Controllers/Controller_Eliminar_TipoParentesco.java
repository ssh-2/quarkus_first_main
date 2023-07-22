package cl.bicevida.TipoParentesco.application.Controllers;

import cl.bicevida.TipoParentesco.domain.puertoEntrada.PuertoEntrada_Eliminar_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_Eliminar_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_TipoParentesco implements PuertoEntrada_Eliminar_TipoParentesco {

    private final PuertoSalida_Eliminar_TipoParentesco puertoSalida;

    public Controller_Eliminar_TipoParentesco(PuertoSalida_Eliminar_TipoParentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
         puertoSalida.eliminarPorID(id);
    }
}
