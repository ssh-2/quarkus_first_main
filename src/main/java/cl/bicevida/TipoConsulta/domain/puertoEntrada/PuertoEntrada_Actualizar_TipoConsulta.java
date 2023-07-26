package cl.bicevida.TipoConsulta.domain.puertoEntrada;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Update_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;

public interface PuertoEntrada_Actualizar_TipoConsulta {
    public Response_DTO_TipoConsulta actualizar(Long id, Request_Update_DTO_TipoConsulta dtoIn);

}
