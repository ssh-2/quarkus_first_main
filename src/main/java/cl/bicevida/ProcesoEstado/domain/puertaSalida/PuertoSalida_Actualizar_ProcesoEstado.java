package cl.bicevida.ProcesoEstado.domain.puertaSalida;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Update_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;

public interface PuertoSalida_Actualizar_ProcesoEstado {
    public Response_DTO_ProcesoEstado actualizar(Long id, Request_Update_DTO_ProcesoEstado dto);

}
