package cl.bicevida.Parentesco.domain.puertoEntrada;

import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;

public interface PuertoEntrada_BuscarPorID_Persona {

    public Response_DTO_Persona buscarPorID(Long id) throws Exception;
}
