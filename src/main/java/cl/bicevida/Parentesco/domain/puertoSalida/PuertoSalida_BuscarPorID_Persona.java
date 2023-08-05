package cl.bicevida.Parentesco.domain.puertoSalida;

import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;

public interface PuertoSalida_BuscarPorID_Persona {
    public Response_DTO_Persona buscarPorID(Long id) throws Exception;
}
