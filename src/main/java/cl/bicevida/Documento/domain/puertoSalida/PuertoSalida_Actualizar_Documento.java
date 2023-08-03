package cl.bicevida.Documento.domain.puertoSalida;

import cl.bicevida.Documento.domain.DTO.Request_Update_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;

public interface PuertoSalida_Actualizar_Documento {
    public Response_DTO_Documento actualizar(Long id, Request_Update_DTO_Documento dto);
}
