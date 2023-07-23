package cl.bicevida.TipoPersona.domain.puertoSalida;

import cl.bicevida.TipoPersona.domain.DTO.Request_Update_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;

public interface PuertoSalida_Actualizar_TipoPersona {
    public Response_DTO_TipoPersona actualizar(Long id, Request_Update_DTO_TipoPersona dto);
}
