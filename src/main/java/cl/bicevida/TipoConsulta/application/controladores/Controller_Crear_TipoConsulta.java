package cl.bicevida.TipoConsulta.application.controladores;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Save_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoEntrada.PuertoEntrada_Crear_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_Crear_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class Controller_Crear_TipoConsulta implements PuertoEntrada_Crear_TipoConsulta {

    private final PuertoSalida_Crear_TipoConsulta puertoSalida;

    public Controller_Crear_TipoConsulta(PuertoSalida_Crear_TipoConsulta puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoConsulta crear(Request_Save_DTO_TipoConsulta dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
