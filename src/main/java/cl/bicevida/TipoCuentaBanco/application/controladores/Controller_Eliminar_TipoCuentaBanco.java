package cl.bicevida.TipoCuentaBanco.application.controladores;

import cl.bicevida.TipoCuentaBanco.domain.puertoEntrada.PuertoEntrada_Eliminar_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Eliminar_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_TipoCuentaBanco implements PuertoEntrada_Eliminar_TipoCuentaBanco {

    private final PuertoSalida_Eliminar_TipoCuentaBanco puertoSalida;

    public Controller_Eliminar_TipoCuentaBanco(PuertoSalida_Eliminar_TipoCuentaBanco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
