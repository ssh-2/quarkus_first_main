package cl.bicevida.Persona.application.Controllers;

import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_BuscarTodos_Persona;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Persona implements PuertoEntrada_BuscarTodos_Persona {

    private final PuertoSalida_BuscarTodos_Persona puertoSalida;

    public Controller_BuscarTodos_Persona(PuertoSalida_BuscarTodos_Persona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }


    @Override
    public List<Response_DTO_Persona> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
