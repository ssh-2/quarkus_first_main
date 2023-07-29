package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Update_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Actualizar_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_Actualizar_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Acutalizar_ProcesoEstado implements PuertoEntrada_Actualizar_ProcesoEstado {

    private final PuertoSalida_Actualizar_ProcesoEstado puertoSalida;

    public Controller_Acutalizar_ProcesoEstado(PuertoSalida_Actualizar_ProcesoEstado puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_ProcesoEstado actualizar(Long id, Request_Update_DTO_ProcesoEstado dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
