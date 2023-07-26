package cl.bicevida.TipoDenuncio.application.controladores;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Save_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoEntrada.PuertoEntrada_Crear_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Crear_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_TipoDenucio implements PuertoEntrada_Crear_TipoDenucio {

    private PuertoSalida_Crear_TipoDenucio puertoSalida;

    public Controller_Crear_TipoDenucio(PuertoSalida_Crear_TipoDenucio puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoDenucio crear(Request_Save_DTO_TipoDenucio dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
