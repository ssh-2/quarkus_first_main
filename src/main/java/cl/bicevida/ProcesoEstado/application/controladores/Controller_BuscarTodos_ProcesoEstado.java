package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarTodos_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_BuscarTodos_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_ProcesoEstado implements PuertoEntrada_BuscarTodos_ProcesoEstado {

    private PuertoSalida_BuscarTodos_ProcesoEstado puertoSalida;

    public Controller_BuscarTodos_ProcesoEstado(PuertoSalida_BuscarTodos_ProcesoEstado puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_ProcesoEstado> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
