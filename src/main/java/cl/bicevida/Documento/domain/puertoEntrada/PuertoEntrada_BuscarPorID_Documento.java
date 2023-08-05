package cl.bicevida.Documento.domain.puertoEntrada;

import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;

public interface PuertoEntrada_BuscarPorID_Documento {
    public Response_DTO_Documento buscarPorID(Long id) throws Exception;

}
