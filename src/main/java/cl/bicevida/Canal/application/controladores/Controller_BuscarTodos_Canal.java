package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BuscarTodos_Canal;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Canal implements PuertoEntrada_BuscarTodos_Canal {

    private final PuertoSalida_BuscarTodos_Canal puertoSalida;

    public Controller_BuscarTodos_Canal(PuertoSalida_BuscarTodos_Canal puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_Canal> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
