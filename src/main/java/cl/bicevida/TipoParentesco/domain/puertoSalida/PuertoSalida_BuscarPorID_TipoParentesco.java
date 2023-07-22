package cl.bicevida.TipoParentesco.domain.puertoSalida;

import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;

public interface PuertoSalida_BuscarPorID_TipoParentesco {
    public Response_DTO_TipoParentesco buscarPorID(Long id) throws Exception;
}
