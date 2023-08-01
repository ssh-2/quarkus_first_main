package cl.bicevida.HomologacionCoberturaLegacy.application.controladores;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoEntrada.PuertoEntrada_BuscarPorID_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_HomologacionCoberturaLegacy implements PuertoEntrada_BuscarPorID_HomologacionCoberturaLegacy {

    private final PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy puertoSalida;

    public Controller_BuscarPorID_HomologacionCoberturaLegacy(PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_HomologacionCoberturaLegacy buscarPorID(Long id) throws Exception {
        return puertoSalida.buscarPorID(id);
    }
}
