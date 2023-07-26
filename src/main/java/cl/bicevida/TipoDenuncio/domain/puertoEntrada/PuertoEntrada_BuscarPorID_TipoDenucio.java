package cl.bicevida.TipoDenuncio.domain.puertoEntrada;

import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;

public interface PuertoEntrada_BuscarPorID_TipoDenucio {
    public Response_DTO_TipoDenucio buscarPorID_PuertoSalida(Long id) throws Exception;
}
