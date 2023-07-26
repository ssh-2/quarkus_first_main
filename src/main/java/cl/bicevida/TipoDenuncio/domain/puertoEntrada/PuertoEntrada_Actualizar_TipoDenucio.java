package cl.bicevida.TipoDenuncio.domain.puertoEntrada;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Update_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;

public interface PuertoEntrada_Actualizar_TipoDenucio {
    public Response_DTO_TipoDenucio actualizar(Long id, Request_Update_DTO_TipoDenucio dtoIn);

}
