package cl.bicevida.Banco.domain.puertoEntrada;

import cl.bicevida.Banco.domain.DTO.Request_Save_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;

public interface PuertoEntrada_Crear_Banco {
    public Response_DTO_Banco crear(Request_Save_DTO_Banco dto);
}
