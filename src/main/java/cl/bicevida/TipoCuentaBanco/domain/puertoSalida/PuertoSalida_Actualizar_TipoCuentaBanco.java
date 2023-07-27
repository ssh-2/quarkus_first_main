package cl.bicevida.TipoCuentaBanco.domain.puertoSalida;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Update_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;

public interface PuertoSalida_Actualizar_TipoCuentaBanco {
    public Response_DTO_TipoCuentaBanco actualizar(Long id, Request_Update_DTO_TipoCuentaBanco dto);
}
