package cl.bicevida.TipoCuentaBanco.domain.puertoEntrada;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;

public interface PuertoEntrada_BuscarPorID_TipoCuentaBanco {
    public Response_DTO_TipoCuentaBanco buscarPorID(Long id) throws Exception;
}
