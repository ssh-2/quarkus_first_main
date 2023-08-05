package cl.bicevida.Parentesco.domain.puertoSalida;

import cl.bicevida.Persona.domain.DTO.Request_Save_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;

public interface PuertoSalida_Crear_Persona {
    public Response_DTO_Persona crear(Request_Save_DTO_Persona entity);
}
