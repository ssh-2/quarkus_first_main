package cl.bicevida.TipoPersona.application.Controllers;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoEntrada.PuertoEntrada_BuscarPorID_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorId_TipoPersona implements PuertoEntrada_BuscarPorID_TipoPersona {

    private final PuertoSalida_BuscarPorID_TipoPersona puertoSalida;

    public Controller_BuscarPorId_TipoPersona(PuertoSalida_BuscarPorID_TipoPersona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoPersona buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
