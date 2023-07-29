package cl.bicevida.ProcesoEstado.domain.puertoEntrada;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;

public interface PuertoEntrada_BuscarPorID_ProcesoEstado {
    public Response_DTO_ProcesoEstado buscarPorID_PuertoEntrada(Long id) throws Exception;
}
