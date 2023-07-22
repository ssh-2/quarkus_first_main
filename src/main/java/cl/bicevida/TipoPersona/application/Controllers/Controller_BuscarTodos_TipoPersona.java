package cl.bicevida.TipoPersona.application.Controllers;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoEntrada.PuertoEntrada_BuscarTodos_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_TipoPersona implements PuertoEntrada_BuscarTodos_TipoPersona {

    private final PuertoSalida_BuscarTodos_TipoPersona puertoSalida;

    public Controller_BuscarTodos_TipoPersona(PuertoSalida_BuscarTodos_TipoPersona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }


    @Override
    public List<Response_DTO_TipoPersona> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
