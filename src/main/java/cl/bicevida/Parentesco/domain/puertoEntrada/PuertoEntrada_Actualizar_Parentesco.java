package cl.bicevida.Parentesco.domain.puertoEntrada;

import cl.bicevida.Parentesco.domain.DTO.Request_Update_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;

public interface PuertoEntrada_Actualizar_Parentesco {

    public Response_DTO_Parentesco actualizar(Long id, Request_Update_DTO_Parentesco dtoIn);
}
