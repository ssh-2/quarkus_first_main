package cl.bicevida.TipoParentesco.application.Controllers;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Update_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoEntrada.PuertoEntrada_Actualizar_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_Actualizar_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_TipoParentesco implements PuertoEntrada_Actualizar_TipoParentesco {

    private final PuertoSalida_Actualizar_TipoParentesco puertoSalida;

    public Controller_Actualizar_TipoParentesco(PuertoSalida_Actualizar_TipoParentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoParentesco actualizar(Long id, Request_Update_DTO_TipoParentesco dtoIn) {
        return puertoSalida.actualizar(id,dtoIn);
    }
}
