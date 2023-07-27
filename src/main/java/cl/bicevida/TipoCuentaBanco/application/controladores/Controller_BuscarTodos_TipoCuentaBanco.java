package cl.bicevida.TipoCuentaBanco.application.controladores;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoEntrada.PuertoEntrada_BuscarTodos_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_TipoCuentaBanco implements PuertoEntrada_BuscarTodos_TipoCuentaBanco {

    private final PuertoSalida_BuscarTodos_TipoCuentaBanco puertoSalida;

    public Controller_BuscarTodos_TipoCuentaBanco(PuertoSalida_BuscarTodos_TipoCuentaBanco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_TipoCuentaBanco> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
