package cl.bicevida.TipoConsulta.domain.puertoSalida;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Save_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;

public interface PuertoSalida_Crear_TipoConsulta {
    public Response_DTO_TipoConsulta crear(Request_Save_DTO_TipoConsulta entity);

}
