package cl.bicevida.TipoPersona.application.Controllers;

import cl.bicevida.TipoPersona.domain.DTO.Request_Update_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoEntrada.PuertoEntrada_Actualizar_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_Actualizar_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_TipoPersona implements PuertoEntrada_Actualizar_TipoPersona {

    private final PuertoSalida_Actualizar_TipoPersona puertoSalida;

    public Controller_Actualizar_TipoPersona(PuertoSalida_Actualizar_TipoPersona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoPersona actualizar(Long id, Request_Update_DTO_TipoPersona dtoIn) {
        return puertoSalida.actualizar(id,dtoIn);
    }
}
