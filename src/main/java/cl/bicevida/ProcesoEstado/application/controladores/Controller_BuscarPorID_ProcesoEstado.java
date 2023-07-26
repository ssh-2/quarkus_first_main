package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarPorID_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_BuscarPorID_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.CONSULTANDO_ID_CONTROLLER;

@ApplicationScoped
@Slf4j
public class Controller_BuscarPorID_ProcesoEstado implements PuertoEntrada_BuscarPorID_ProcesoEstado {

    private PuertoSalida_BuscarPorID_ProcesoEstado puertoSalida;

    public Controller_BuscarPorID_ProcesoEstado(PuertoSalida_BuscarPorID_ProcesoEstado puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_ProcesoEstado buscarPorID_PuertoEntrada(Long id) throws Exception {
        log.error(CONSULTANDO_ID_CONTROLLER + id);
        return puertoSalida.buscarPorID(id);
    }
}
