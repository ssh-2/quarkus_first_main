package cl.bicevida.Banco.domain.puertoEntrada;

import cl.bicevida.Banco.domain.DTO.Request_Update_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;

public interface PuertoEntrada_Actualizar_Banco {
    public Response_DTO_Banco actualizar(Long id, Request_Update_DTO_Banco dtoIn);
}
