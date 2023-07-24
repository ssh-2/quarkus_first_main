package cl.bicevida.Persona.application.Controllers;

import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_BuscarPorID_Persona;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorId_Persona implements PuertoEntrada_BuscarPorID_Persona {

    private final PuertoSalida_BuscarPorID_Persona puertoSalida;

    public Controller_BuscarPorId_Persona(PuertoSalida_BuscarPorID_Persona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Persona buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
