package cl.bicevida.Canal.domain.puertoEntrada;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;

public interface PuertoEntrada_BuscarPorID_Canal {
    public Response_DTO_Canal buscarPorID_PuertoEntrada(Long id) throws Exception;
}
