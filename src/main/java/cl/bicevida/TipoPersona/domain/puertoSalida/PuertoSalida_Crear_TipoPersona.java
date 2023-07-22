package cl.bicevida.TipoPersona.domain.puertoSalida;

import cl.bicevida.TipoPersona.domain.DTO.Request_Save_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;

public interface PuertoSalida_Crear_TipoPersona {
    public Response_DTO_TipoPersona crear(Request_Save_DTO_TipoPersona entity);
}
