package cl.bicevida.TipoDenuncio.domain.puertoSalida;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Save_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;

public interface PuertoSalida_Crear_TipoDenucio {
    public Response_DTO_TipoDenucio crear(Request_Save_DTO_TipoDenucio entity);
}