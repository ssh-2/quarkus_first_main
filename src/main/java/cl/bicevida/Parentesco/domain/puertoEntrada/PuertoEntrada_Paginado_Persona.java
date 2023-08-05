package cl.bicevida.Parentesco.domain.puertoEntrada;

import cl.bicevida.Persona.domain.DTO.Request_Paginado_DTO_Persona;
import cl.bicevida.Utils.PaginadoResponse;

public interface PuertoEntrada_Paginado_Persona {

    public PaginadoResponse buscarPaginado(Request_Paginado_DTO_Persona dto);
}
