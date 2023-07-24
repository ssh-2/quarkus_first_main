package cl.bicevida.Canal.domain.puertoEntrada;

import cl.bicevida.Canal.domain.DTO.Request_Update_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;

public interface PuertoEntrada_Actualizar_Canal {
    public Response_DTO_Canal actualizar(Long id, Request_Update_DTO_Canal dtoIn);
}
