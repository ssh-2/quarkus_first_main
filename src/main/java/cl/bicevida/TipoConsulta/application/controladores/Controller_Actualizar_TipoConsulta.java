package cl.bicevida.TipoConsulta.application.controladores;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Update_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoEntrada.PuertoEntrada_Actualizar_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_Actualizar_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_TipoConsulta implements PuertoEntrada_Actualizar_TipoConsulta {

    private final PuertoSalida_Actualizar_TipoConsulta puertoSalida;

    public Controller_Actualizar_TipoConsulta(PuertoSalida_Actualizar_TipoConsulta puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoConsulta actualizar(Long id, Request_Update_DTO_TipoConsulta dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
