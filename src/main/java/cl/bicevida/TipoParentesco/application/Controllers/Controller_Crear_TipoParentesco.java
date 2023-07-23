package cl.bicevida.TipoParentesco.application.Controllers;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Save_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoEntrada.PuertoEntrada_Crear_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_Crear_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class Controller_Crear_TipoParentesco implements PuertoEntrada_Crear_TipoParentesco {

    private final PuertoSalida_Crear_TipoParentesco puertoSalida;

    public Controller_Crear_TipoParentesco(PuertoSalida_Crear_TipoParentesco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoParentesco crear(Request_Save_DTO_TipoParentesco dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
