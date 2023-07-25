package cl.bicevida.Liquidador.domain.puertoSalida;

import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;

public interface PuertoSalida_Crear_Liquidador {

    public Response_DTO_Liquidador crear(Request_Save_DTO_Liquidador entity);

}
