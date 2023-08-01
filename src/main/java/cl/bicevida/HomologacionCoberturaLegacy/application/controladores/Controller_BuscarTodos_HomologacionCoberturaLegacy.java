package cl.bicevida.HomologacionCoberturaLegacy.application.controladores;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoEntrada.PuertoEntrada_BuscarTodos_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_BuscarTodos_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_HomologacionCoberturaLegacy implements PuertoEntrada_BuscarTodos_HomologacionCoberturaLegacy {

    private final PuertoSalida_BuscarTodos_HomologacionCoberturaLegacy puertoSalida;

    public Controller_BuscarTodos_HomologacionCoberturaLegacy(PuertoSalida_BuscarTodos_HomologacionCoberturaLegacy puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_HomologacionCoberturaLegacy> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
