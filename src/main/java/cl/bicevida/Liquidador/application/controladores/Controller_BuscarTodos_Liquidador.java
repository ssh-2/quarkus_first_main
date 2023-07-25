package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarTodos_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Liquidador implements PuertoEntrada_BuscarTodos_Liquidador {

    private PuertoSalida_BuscarTodos_Liquidador puertoSalida;

    public Controller_BuscarTodos_Liquidador(PuertoSalida_BuscarTodos_Liquidador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_Liquidador> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
