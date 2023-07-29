package cl.bicevida.Liquidador.domain.puertoEntrada;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;

import java.util.List;

public interface PuertoEntrada_BuscarTodos_Liquidador {
    public List<Response_DTO_Liquidador> buscarTodos();
}
