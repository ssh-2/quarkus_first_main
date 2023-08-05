package cl.bicevida.Parentesco.application.Controllers;

import cl.bicevida.Persona.domain.DTO.Request_Update_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.puertoEntrada.PuertoEntrada_Actualizar_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Actualizar_Persona;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Persona implements PuertoEntrada_Actualizar_Persona {

    private final PuertoSalida_Actualizar_Persona puertoSalida;

    public Controller_Actualizar_Persona(PuertoSalida_Actualizar_Persona puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Persona actualizar(Long id, Request_Update_DTO_Persona dtoIn) {
        return puertoSalida.actualizar(id,dtoIn);
    }
}
