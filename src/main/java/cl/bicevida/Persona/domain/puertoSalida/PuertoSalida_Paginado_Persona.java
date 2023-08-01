package cl.bicevida.Persona.domain.puertoSalida;

import cl.bicevida.Persona.domain.DTO.Request_Paginado_DTO_Persona;
import cl.bicevida.Utils.PaginadoResponse;

public interface PuertoSalida_Paginado_Persona {

    public PaginadoResponse buscarPaginado(Request_Paginado_DTO_Persona dto);
}
