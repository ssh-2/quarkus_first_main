package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Parentesco.domain.DTO.Request_Update_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.puertoEntrada.PuertoEntrada_Actualizar_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_Actualizar_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Parentesco implements PuertoEntrada_Actualizar_Parentesco {

    private final PuertoSalida_Actualizar_Parentesco puertoSalida;

    public Controller_Actualizar_Parentesco(PuertoSalida_Actualizar_Parentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Parentesco actualizar(Long id, Request_Update_DTO_Parentesco dtoIn) {
        return puertoSalida.actualizar(id,dtoIn);
    }
}
