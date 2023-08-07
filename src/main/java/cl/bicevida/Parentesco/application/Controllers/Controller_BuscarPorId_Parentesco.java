package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_BuscarPorID_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorId_Parentesco implements PuertoEntrada_BuscarPorID_Parentesco {

    private final PuertoSalida_BuscarPorID_Parentesco puertoSalida;

    public Controller_BuscarPorId_Parentesco(PuertoSalida_BuscarPorID_Parentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Parentesco buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
