package cl.bicevida.TipoParentesco.application.Controllers;

import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoEntrada.PuertoEntrada_BuscarTodos_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_TipoParentesco implements PuertoEntrada_BuscarTodos_TipoParentesco {

    private final PuertoSalida_BuscarTodos_TipoParentesco puertoSalida;

    public Controller_BuscarTodos_TipoParentesco(PuertoSalida_BuscarTodos_TipoParentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }


    @Override
    public List<Response_DTO_TipoParentesco> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
