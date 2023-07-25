package cl.bicevida.Liquidador.domain.puertoEntrada;

import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;

public interface PuertoEntrada_Crear_Liquidador {
    public Response_DTO_Liquidador crear(Request_Save_DTO_Liquidador dto);
}
