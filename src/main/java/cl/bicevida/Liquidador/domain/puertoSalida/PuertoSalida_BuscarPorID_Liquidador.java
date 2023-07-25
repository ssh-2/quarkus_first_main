package cl.bicevida.Liquidador.domain.puertoSalida;

import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;

public interface PuertoSalida_BuscarPorID_Liquidador {
    public Response_DTO_Liquidador buscarPorID(Long id) throws Exception;
}
