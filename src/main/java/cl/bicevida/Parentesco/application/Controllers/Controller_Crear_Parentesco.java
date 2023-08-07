package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Parentesco.domain.DTO.Request_Save_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.puertoEntrada.PuertoEntrada_Crear_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_Crear_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class Controller_Crear_Parentesco implements PuertoEntrada_Crear_Parentesco {

    private final PuertoSalida_Crear_Parentesco puertoSalida;

    public Controller_Crear_Parentesco(PuertoSalida_Crear_Parentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Parentesco crear(Request_Save_DTO_Parentesco dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
