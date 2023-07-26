package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Save_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Crear_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_Crear_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_ProcesoEstado implements PuertoEntrada_Crear_ProcesoEstado {

    private final PuertoSalida_Crear_ProcesoEstado puertoSalida;

    public Controller_Crear_ProcesoEstado(PuertoSalida_Crear_ProcesoEstado puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_ProcesoEstado crear(Request_Save_DTO_ProcesoEstado dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
