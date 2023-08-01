package cl.bicevida.Banco.domain.puertoSalida;

import cl.bicevida.Banco.domain.DTO.Request_Update_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;

public interface PuertoSalida_Actualizar_Banco {
    public Response_DTO_Banco actualizar(Long id, Request_Update_DTO_Banco dto);
}
