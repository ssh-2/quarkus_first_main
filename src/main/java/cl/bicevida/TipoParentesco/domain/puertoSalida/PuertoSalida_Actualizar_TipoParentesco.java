package cl.bicevida.TipoParentesco.domain.puertoSalida;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Update_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;

public interface PuertoSalida_Actualizar_TipoParentesco {
    public Response_DTO_TipoParentesco actualizar(Long id, Request_Update_DTO_TipoParentesco dto);
}