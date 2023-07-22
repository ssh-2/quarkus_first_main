package cl.bicevida.TipoPersona.application.Controllers;

import cl.bicevida.TipoPersona.domain.DTO.Request_Save_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoEntrada.PuertoEntrada_Crear_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_Crear_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class Controller_Crear_TipoPersona implements PuertoEntrada_Crear_TipoPersona {

    private final PuertoSalida_Crear_TipoPersona puertoSalida;

    public Controller_Crear_TipoPersona(PuertoSalida_Crear_TipoPersona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoPersona crear(Request_Save_DTO_TipoPersona dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
