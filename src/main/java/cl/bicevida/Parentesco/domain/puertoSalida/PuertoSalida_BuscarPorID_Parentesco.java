package cl.bicevida.Parentesco.domain.puertoSalida;

import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;

public interface PuertoSalida_BuscarPorID_Parentesco {
    public Response_DTO_Parentesco buscarPorID(Long id) throws Exception;
}
