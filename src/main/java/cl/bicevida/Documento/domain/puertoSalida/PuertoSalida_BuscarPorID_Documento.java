package cl.bicevida.Documento.domain.puertoSalida;

import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;

public interface PuertoSalida_BuscarPorID_Documento {
    public Response_DTO_Documento buscarPorID(Long id) throws Exception;
}
