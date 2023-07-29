package cl.bicevida.Canal.domain.puertoSalida;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;

public interface PuertoSalida_BuscarPorID_Canal {
    public Response_DTO_Canal buscarPorID(Long id) throws Exception;
}
