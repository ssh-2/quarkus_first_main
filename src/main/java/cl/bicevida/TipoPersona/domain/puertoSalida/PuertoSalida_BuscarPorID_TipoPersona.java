package cl.bicevida.TipoPersona.domain.puertoSalida;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;

public interface PuertoSalida_BuscarPorID_TipoPersona {
    public Response_DTO_TipoPersona buscarPorID(Long id) throws Exception;
}
