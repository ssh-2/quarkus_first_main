package cl.bicevida.TipoCuentaBanco.application.controladores;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Save_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoEntrada.PuertoEntrada_Crear_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Crear_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_TipoCuentaBanco implements PuertoEntrada_Crear_TipoCuentaBanco {

    private final PuertoSalida_Crear_TipoCuentaBanco puertoSalida;

    public Controller_Crear_TipoCuentaBanco(PuertoSalida_Crear_TipoCuentaBanco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_TipoCuentaBanco crear(Request_Save_DTO_TipoCuentaBanco dto) {
        return puertoSalida.crear(dto);
    }
}
