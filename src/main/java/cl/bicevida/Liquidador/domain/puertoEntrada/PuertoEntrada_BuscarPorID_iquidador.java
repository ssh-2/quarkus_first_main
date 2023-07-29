package cl.bicevida.Liquidador.domain.puertoEntrada;

import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;

public interface PuertoEntrada_BuscarPorID_iquidador {
    public Response_DTO_Liquidador buscarPorID(Long id) throws Exception;
}
