package cl.bicevida.HomologacionCoberturaLegacy.application.controladores;

import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoEntrada.PuertoEntrada_Eliminar_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_Eliminar_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_HomologacionCoberturaLegacy implements PuertoEntrada_Eliminar_HomologacionCoberturaLegacy {

    private final PuertoSalida_Eliminar_HomologacionCoberturaLegacy puertoSalida;

    public Controller_Eliminar_HomologacionCoberturaLegacy(PuertoSalida_Eliminar_HomologacionCoberturaLegacy puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
