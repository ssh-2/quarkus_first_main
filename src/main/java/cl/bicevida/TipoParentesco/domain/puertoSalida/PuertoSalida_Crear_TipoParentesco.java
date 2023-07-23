package cl.bicevida.TipoParentesco.domain.puertoSalida;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Save_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;

public interface PuertoSalida_Crear_TipoParentesco {
    public Response_DTO_TipoParentesco crear(Request_Save_DTO_TipoParentesco entity);
}
