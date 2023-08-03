package cl.bicevida.Documento.application.controladores;

import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.puertoEntrada.PuertoEntrada_BuscarPorID_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_BuscarPorID_Documento;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_Documento implements PuertoEntrada_BuscarPorID_Documento {

    private final PuertoSalida_BuscarPorID_Documento puertoSalida;

    public Controller_BuscarPorID_Documento(PuertoSalida_BuscarPorID_Documento puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Documento buscarPorID(Long id) throws Exception {
        return puertoSalida.buscarPorID(id);
    }
}
