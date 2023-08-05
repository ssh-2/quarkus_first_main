package cl.bicevida.Parentesco.domain.puertoSalida;

import cl.bicevida.Persona.domain.DTO.Request_Update_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;

public interface PuertoSalida_Actualizar_Persona {
    public Response_DTO_Persona actualizar(Long id, Request_Update_DTO_Persona dto);
}
