package cl.bicevida.Canal.domain.puertoSalida;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;

public interface PuertoSalida_BusacrPorID_Canal {
    public Response_DTO_Canal buscarPorID(Long id) throws Exception;
}
