package cl.bicevida.TipoConsulta.domain.puertoSalida;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Update_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;

public interface PuertoSalida_Actualizar_TipoConsulta {
    public Response_DTO_TipoConsulta actualizar(Long id, Request_Update_DTO_TipoConsulta dto);
}
