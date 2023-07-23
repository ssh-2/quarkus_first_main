package cl.bicevida.TipoParentesco.application.Controllers;

import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoEntrada.PuertoEntrada_BuscarPorID_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorId_TipoParentesco implements PuertoEntrada_BuscarPorID_TipoParentesco {

    private final PuertoSalida_BuscarPorID_TipoParentesco puertoSalida;

    public Controller_BuscarPorId_TipoParentesco(PuertoSalida_BuscarPorID_TipoParentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoParentesco buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
