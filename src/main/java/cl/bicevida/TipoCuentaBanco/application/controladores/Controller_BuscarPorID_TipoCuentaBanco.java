package cl.bicevida.TipoCuentaBanco.application.controladores;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoEntrada.PuertoEntrada_BuscarPorID_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorID_TipoCuentaBanco implements PuertoEntrada_BuscarPorID_TipoCuentaBanco {

    private final PuertoSalida_BuscarPorID_TipoCuentaBanco puertoSalida;

    public Controller_BuscarPorID_TipoCuentaBanco(PuertoSalida_BuscarPorID_TipoCuentaBanco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoCuentaBanco buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
