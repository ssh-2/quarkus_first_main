package cl.bicevida.Canal.domain.puertoEntrada;

import cl.bicevida.Canal.domain.DTO.Request_Save_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;

public interface PuertoEntrada_Crear_Canal {
    public Response_DTO_Canal crear(Request_Save_DTO_Canal dto);
}
