package cl.bicevida.Liquidador.application.controladores;


import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_BuscarPorID_iquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarPorID_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorID_Liquidador implements PuertoEntrada_BuscarPorID_iquidador {

    private final PuertoSalida_BuscarPorID_Liquidador puertoSalida;

    public Controller_BuscarPorID_Liquidador(PuertoSalida_BuscarPorID_Liquidador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Liquidador buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
