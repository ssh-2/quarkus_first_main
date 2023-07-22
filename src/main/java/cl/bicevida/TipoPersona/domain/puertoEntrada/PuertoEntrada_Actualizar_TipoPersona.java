package cl.bicevida.TipoPersona.domain.puertoEntrada;

import cl.bicevida.TipoPersona.domain.DTO.Request_Update_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;

public interface PuertoEntrada_Actualizar_TipoPersona {

    public Response_DTO_TipoPersona actualizar(Long id, Request_Update_DTO_TipoPersona dtoIn);
}
