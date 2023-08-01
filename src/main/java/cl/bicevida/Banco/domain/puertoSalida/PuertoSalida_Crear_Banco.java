package cl.bicevida.Banco.domain.puertoSalida;

import cl.bicevida.Banco.domain.DTO.Request_Save_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;

public interface PuertoSalida_Crear_Banco {
    public Response_DTO_Banco crear(Request_Save_DTO_Banco entity);
}
