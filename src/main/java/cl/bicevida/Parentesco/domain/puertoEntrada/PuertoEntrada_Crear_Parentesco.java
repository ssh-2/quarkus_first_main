package cl.bicevida.Parentesco.domain.puertoEntrada;

import cl.bicevida.Parentesco.domain.DTO.Request_Save_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;

public interface PuertoEntrada_Crear_Parentesco {
    public Response_DTO_Parentesco crear(Request_Save_DTO_Parentesco dto);
}
