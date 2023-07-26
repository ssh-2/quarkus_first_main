package cl.bicevida.ProcesoEstado.domain.puertoEntrada;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Update_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;

public interface PuertoEntrada_Actualizar_ProcesoEstado {
    public Response_DTO_ProcesoEstado actualizar(Long id, Request_Update_DTO_ProcesoEstado dtoIn);
}
