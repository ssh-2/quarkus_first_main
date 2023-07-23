package cl.bicevida.TipoPersona.domain.puertoEntrada;

import cl.bicevida.TipoPersona.domain.DTO.Request_Save_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;

public interface PuertoEntrada_Crear_TipoPersona {
    public Response_DTO_TipoPersona crear(Request_Save_DTO_TipoPersona dto);
}
