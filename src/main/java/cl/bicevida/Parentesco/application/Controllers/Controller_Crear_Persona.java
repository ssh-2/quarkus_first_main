package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Persona.domain.DTO.Request_Save_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.puertoEntrada.PuertoEntrada_Crear_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Crear_Persona;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class Controller_Crear_Persona implements PuertoEntrada_Crear_Persona {

    private final PuertoSalida_Crear_Persona puertoSalida;

    public Controller_Crear_Persona(PuertoSalida_Crear_Persona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Persona crear(Request_Save_DTO_Persona dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
