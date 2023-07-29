package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Update_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_Actualizar_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Actualizar_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_TipoDenucio implements PuertoEntrada_Actualizar_TipoDenucio {

    private PuertoSalida_Actualizar_TipoDenucio puertoSalida;

    public Controller_Actualizar_TipoDenucio(PuertoSalida_Actualizar_TipoDenucio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoDenucio actualizar(Long id, Request_Update_DTO_TipoDenucio dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
