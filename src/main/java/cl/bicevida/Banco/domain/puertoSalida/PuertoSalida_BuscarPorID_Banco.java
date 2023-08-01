package cl.bicevida.Banco.domain.puertoSalida;

import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;

public interface PuertoSalida_BuscarPorID_Banco {
    public Response_DTO_Banco buscarPorID(Long id) throws Exception;
}
