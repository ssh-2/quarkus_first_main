package cl.bicevida.TipoConsulta.domain.puertoSalida;

import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;

public interface PuertoSalida_BuscarPorID_TipoConsulta {
    public Response_DTO_TipoConsulta buscarPorID(Long id) throws Exception;
}
