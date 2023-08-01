package cl.bicevida.Banco.application.controladores;

import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_BuscarPorID_Banco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_Banco implements PuertoEntrada_BuscarPorID_Banco {

    private final PuertoSalida_BuscarPorID_Banco puertoSalida;

    public Controller_BuscarPorID_Banco(PuertoSalida_BuscarPorID_Banco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Banco buscarPorID(Long id) throws Exception {
        return puertoSalida.buscarPorID(id);
    }
}
