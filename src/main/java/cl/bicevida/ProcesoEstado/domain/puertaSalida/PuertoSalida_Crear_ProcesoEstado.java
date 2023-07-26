package cl.bicevida.ProcesoEstado.domain.puertaSalida;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Save_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;

public interface PuertoSalida_Crear_ProcesoEstado {
    public Response_DTO_ProcesoEstado crear(Request_Save_DTO_ProcesoEstado entity);
}
