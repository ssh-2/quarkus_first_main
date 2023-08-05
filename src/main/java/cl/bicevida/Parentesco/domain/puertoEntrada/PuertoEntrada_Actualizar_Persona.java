package cl.bicevida.Parentesco.domain.puertoEntrada;

import cl.bicevida.Persona.domain.DTO.Request_Update_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;

public interface PuertoEntrada_Actualizar_Persona {

    public Response_DTO_Persona actualizar(Long id, Request_Update_DTO_Persona dtoIn);
}
