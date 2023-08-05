package cl.bicevida.Documento.domain.puertoEntrada;

import cl.bicevida.Documento.domain.DTO.Request_Update_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;

public interface PuertoEntrada_Actualizar_Documento {
    public Response_DTO_Documento actualizar(Long id, Request_Update_DTO_Documento dtoIn);
}
