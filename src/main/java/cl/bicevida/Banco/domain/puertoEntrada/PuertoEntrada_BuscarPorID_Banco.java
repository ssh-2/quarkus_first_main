package cl.bicevida.Banco.domain.puertoEntrada;

import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;

public interface PuertoEntrada_BuscarPorID_Banco {
    public Response_DTO_Banco buscarPorID(Long id) throws Exception;
}
