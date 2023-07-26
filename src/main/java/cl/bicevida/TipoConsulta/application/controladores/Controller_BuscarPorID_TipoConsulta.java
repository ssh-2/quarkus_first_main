package cl.bicevida.TipoConsulta.application.controladores;

import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoEntrada.PuertoEntrada_BuscarPorID_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorID_TipoConsulta implements PuertoEntrada_BuscarPorID_TipoConsulta {

    private final PuertoSalida_BuscarPorID_TipoConsulta puertoSalida;

    public Controller_BuscarPorID_TipoConsulta(PuertoSalida_BuscarPorID_TipoConsulta puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoConsulta buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
