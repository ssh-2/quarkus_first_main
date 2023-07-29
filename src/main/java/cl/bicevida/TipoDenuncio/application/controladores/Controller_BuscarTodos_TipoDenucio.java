package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_BuscarTodos_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_TipoDenucio implements PuertoEntrada_BuscarTodos_TipoDenucio {

    private PuertoSalida_BuscarTodos_TipoDenucio puertoSalida;

    public Controller_BuscarTodos_TipoDenucio(PuertoSalida_BuscarTodos_TipoDenucio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_TipoDenucio> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
