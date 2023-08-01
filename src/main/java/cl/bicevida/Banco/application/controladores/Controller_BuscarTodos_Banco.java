package cl.bicevida.Banco.application.controladores;

import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_BuscarTodos_Banco;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Banco implements PuertoEntrada_BuscarTodos_Banco {

    private final PuertoSalida_BuscarTodos_Banco puertoSalida;

    public Controller_BuscarTodos_Banco(PuertoSalida_BuscarTodos_Banco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_Banco> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
