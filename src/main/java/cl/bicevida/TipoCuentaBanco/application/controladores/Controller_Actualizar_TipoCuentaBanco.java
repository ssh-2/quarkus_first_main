package cl.bicevida.TipoCuentaBanco.application.controladores;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Update_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoEntrada.PuertoEntrada_Actualizar_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Actualizar_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_TipoCuentaBanco implements PuertoEntrada_Actualizar_TipoCuentaBanco {

    private final PuertoSalida_Actualizar_TipoCuentaBanco puertoSalida;

    public Controller_Actualizar_TipoCuentaBanco(PuertoSalida_Actualizar_TipoCuentaBanco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoCuentaBanco actualizar(Long id, Request_Update_DTO_TipoCuentaBanco dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
