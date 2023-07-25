package cl.bicevida.Liquidador.domain.puertoSalida;

import cl.bicevida.Liquidador.domain.DTO.Request_Update_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;

public interface PuertoSalida_Actualizar_Liquidador {
    public Response_DTO_Liquidador actualizar(Long id, Request_Update_DTO_Liquidador dto);
}
