package cl.bicevida.Documento.domain.puertoEntrada;

import cl.bicevida.Documento.domain.DTO.Request_Save_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;

public interface PuertoEntrada_Crear_Documento {
    public Response_DTO_Documento crear(Request_Save_DTO_Documento dto);
}
