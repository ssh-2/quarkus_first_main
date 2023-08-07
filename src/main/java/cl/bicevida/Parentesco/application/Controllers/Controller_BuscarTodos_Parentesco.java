package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_BuscarTodos_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Parentesco implements PuertoEntrada_BuscarTodos_Parentesco {

    private final PuertoSalida_BuscarTodos_Parentesco puertoSalida;

    public Controller_BuscarTodos_Parentesco(PuertoSalida_BuscarTodos_Parentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }


    @Override
    public List<Response_DTO_Parentesco> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
