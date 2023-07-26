package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_BuscarPorID_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_TipoDenucio implements PuertoEntrada_BuscarPorID_TipoDenucio {

    private PuertoSalida_BuscarPorID_TipoDenucio puertoSalida;

    public Controller_BuscarPorID_TipoDenucio(PuertoSalida_BuscarPorID_TipoDenucio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoDenucio buscarPorID_PuertoSalida(Long id) throws Exception {
        return puertoSalida.buscarPorID_PuertoSalida(id);
    }
}
