package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Persona.domain.DTO.Request_Paginado_DTO_Persona;
import cl.bicevida.Persona.domain.puertoEntrada.PuertoEntrada_Paginado_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Paginado_Persona;
import cl.bicevida.Utils.PaginadoResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Paginado_Persona implements PuertoEntrada_Paginado_Persona {

    private final PuertoSalida_Paginado_Persona puertoSalida;

    public Controller_Paginado_Persona(PuertoSalida_Paginado_Persona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public PaginadoResponse buscarPaginado(Request_Paginado_DTO_Persona dto) {
        return puertoSalida.buscarPaginado(dto);
    }
}
