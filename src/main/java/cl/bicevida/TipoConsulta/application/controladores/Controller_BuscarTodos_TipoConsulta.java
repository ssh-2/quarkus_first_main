package cl.bicevida.TipoConsulta.application.controladores;

import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoEntrada.PuertoEntrada_BuscarTodos_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_TipoConsulta implements PuertoEntrada_BuscarTodos_TipoConsulta {

    private final PuertoSalida_BuscarTodos_TipoConsulta puertoSalida;

    public Controller_BuscarTodos_TipoConsulta(PuertoSalida_BuscarTodos_TipoConsulta puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_TipoConsulta> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
