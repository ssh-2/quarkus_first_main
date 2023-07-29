package cl.bicevida.TipoConsulta.application.controladores;

import cl.bicevida.TipoConsulta.domain.puertoEntrada.PuertoEntrada_Eliminar_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_Eliminar_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_TipoConsulta implements PuertoEntrada_Eliminar_TipoConsulta {

    private final PuertoSalida_Eliminar_TipoConsulta puertoSalida;

    public Controller_Eliminar_TipoConsulta(PuertoSalida_Eliminar_TipoConsulta puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
