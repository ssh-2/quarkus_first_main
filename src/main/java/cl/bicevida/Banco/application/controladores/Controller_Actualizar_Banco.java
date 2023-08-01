package cl.bicevida.Banco.application.controladores;

import cl.bicevida.Banco.domain.DTO.Request_Update_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.puertoEntrada.PuertoEntrada_Actualizar_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_Actualizar_Banco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_Banco implements PuertoEntrada_Actualizar_Banco {

    private final PuertoSalida_Actualizar_Banco puertoSalida;

    public Controller_Actualizar_Banco(PuertoSalida_Actualizar_Banco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Banco actualizar(Long id, Request_Update_DTO_Banco dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
