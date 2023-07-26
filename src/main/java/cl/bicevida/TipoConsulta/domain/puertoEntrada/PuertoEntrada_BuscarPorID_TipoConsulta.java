package cl.bicevida.TipoConsulta.domain.puertoEntrada;

import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;

public interface PuertoEntrada_BuscarPorID_TipoConsulta {
    public Response_DTO_TipoConsulta buscarPorID(Long id) throws Exception;
}
