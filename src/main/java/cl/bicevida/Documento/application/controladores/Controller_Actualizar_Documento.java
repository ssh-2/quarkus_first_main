package cl.bicevida.Documento.application.controladores;

import cl.bicevida.Documento.domain.DTO.Request_Update_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.puertoEntrada.PuertoEntrada_Actualizar_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_Actualizar_Documento;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Documento implements PuertoEntrada_Actualizar_Documento {

    private final PuertoSalida_Actualizar_Documento puertoSalida;

    public Controller_Actualizar_Documento(PuertoSalida_Actualizar_Documento puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Documento actualizar(Long id, Request_Update_DTO_Documento dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
