package cl.bicevida.TipoPersona.domain.puertoEntrada;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;

public interface PuertoEntrada_BuscarPorID_TipoPersona {

    public Response_DTO_TipoPersona buscarPorID(Long id) throws Exception;
}
