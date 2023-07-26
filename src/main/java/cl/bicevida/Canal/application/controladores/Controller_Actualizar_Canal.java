package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.DTO.Request_Update_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_Actualizar_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Actualizar_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Canal implements PuertoEntrada_Actualizar_Canal {

    private final PuertoSalida_Actualizar_Canal puertoSalida;

    public Controller_Actualizar_Canal(PuertoSalida_Actualizar_Canal puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Canal actualizar(Long id, Request_Update_DTO_Canal dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
