package cl.bicevida.Parentesco.domain.puertoSalida;

import cl.bicevida.Parentesco.domain.DTO.Request_Save_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;

public interface PuertoSalida_Crear_Parentesco {
    public Response_DTO_Parentesco crear(Request_Save_DTO_Parentesco entity);
}
