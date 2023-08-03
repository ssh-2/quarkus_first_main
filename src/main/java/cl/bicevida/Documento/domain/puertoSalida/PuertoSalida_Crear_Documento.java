package cl.bicevida.Documento.domain.puertoSalida;

import cl.bicevida.Documento.domain.DTO.Request_Save_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;

public interface PuertoSalida_Crear_Documento {
    public Response_DTO_Documento crear(Request_Save_DTO_Documento entity);
}
