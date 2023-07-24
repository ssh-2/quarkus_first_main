package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BusacrPorID_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorID_Canal implements PuertoEntrada_BuscarPorID_Canal {

    private PuertoSalida_BusacrPorID_Canal puertoSalida;

    public Controller_BuscarPorID_Canal(PuertoSalida_BusacrPorID_Canal puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Canal buscarPorID_PuertoSalida(Long id) throws Exception {
        log.info(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
