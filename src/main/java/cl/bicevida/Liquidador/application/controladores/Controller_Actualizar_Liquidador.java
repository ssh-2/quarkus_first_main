package cl.bicevida.Liquidador.application.controladores;

import cl.bicevida.Liquidador.domain.DTO.Request_Update_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_Actualizar_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Actualizar_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Liquidador implements PuertoEntrada_Actualizar_Liquidador {

    private PuertoSalida_Actualizar_Liquidador puertoSalida;

    public Controller_Actualizar_Liquidador(PuertoSalida_Actualizar_Liquidador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Liquidador actualizar(Long id, Request_Update_DTO_Liquidador dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
