package cl.bicevida.Canal.domain.puertoSalida;

import cl.bicevida.Canal.domain.DTO.Request_Save_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;

public interface PuertoSalida_Crear_Canal {
    public Response_DTO_Canal crear(Request_Save_DTO_Canal entity);
}
