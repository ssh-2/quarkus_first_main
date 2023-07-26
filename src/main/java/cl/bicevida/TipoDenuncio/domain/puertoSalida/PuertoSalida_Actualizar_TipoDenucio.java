package cl.bicevida.TipoDenuncio.domain.puertoSalida;

import cl.bicevida.Canal.domain.DTO.Request_Update_DTO_Canal;
import cl.bicevida.TipoDenuncio.domain.DTO.Request_Update_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;

public interface PuertoSalida_Actualizar_TipoDenucio {
    public Response_DTO_TipoDenucio actualizar(Long id, Request_Update_DTO_TipoDenucio dto);}
