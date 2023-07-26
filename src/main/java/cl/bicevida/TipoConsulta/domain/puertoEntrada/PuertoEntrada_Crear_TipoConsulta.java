package cl.bicevida.TipoConsulta.domain.puertoEntrada;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Save_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;

public interface PuertoEntrada_Crear_TipoConsulta {
    public Response_DTO_TipoConsulta crear(Request_Save_DTO_TipoConsulta dto);
}
