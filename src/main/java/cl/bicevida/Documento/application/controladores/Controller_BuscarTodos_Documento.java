package cl.bicevida.Documento.application.controladores;

import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.puertoEntrada.PuertoEntrada_BuscarTodos_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_BuscarTodos_Documento;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Controller_BuscarTodos_Documento implements PuertoEntrada_BuscarTodos_Documento {

    private final PuertoSalida_BuscarTodos_Documento puertoSalida;

    public Controller_BuscarTodos_Documento(PuertoSalida_BuscarTodos_Documento puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public List<Response_DTO_Documento> buscarTodos() {
        return puertoSalida.buscarTodos();
    }
}
