package cl.bicevida.Documento.application.controladores;

import cl.bicevida.Documento.domain.DTO.Request_Save_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.puertoEntrada.PuertoEntrada_Crear_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_Crear_Documento;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_Documento implements PuertoEntrada_Crear_Documento {

    private final PuertoSalida_Crear_Documento puertoSalida;

    public Controller_Crear_Documento(PuertoSalida_Crear_Documento puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Documento crear(Request_Save_DTO_Documento dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
