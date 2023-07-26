package cl.bicevida.ProcesoEstado.domain.puertaSalida;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;

public interface PuertoSalida_BuscarPorID_ProcesoEstado {
    public Response_DTO_ProcesoEstado buscarPorID(Long id) throws Exception;
}
