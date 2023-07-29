package cl.bicevida.TipoCuentaBanco.domain.puertoSalida;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Save_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;

public interface PuertoSalida_Crear_TipoCuentaBanco {
    public Response_DTO_TipoCuentaBanco crear(Request_Save_DTO_TipoCuentaBanco entity);
}
