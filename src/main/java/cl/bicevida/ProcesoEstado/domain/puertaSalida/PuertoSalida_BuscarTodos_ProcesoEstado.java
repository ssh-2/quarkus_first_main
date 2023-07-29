package cl.bicevida.ProcesoEstado.domain.puertaSalida;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;

import java.util.List;

public interface PuertoSalida_BuscarTodos_ProcesoEstado {
    public List<Response_DTO_ProcesoEstado> buscarTodos();
}
