package cl.bicevida.HomologacionCoberturaLegacy.domain.puertoEntrada;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;

public interface PuertoEntrada_BuscarPorID_HomologacionCoberturaLegacy {
    public Response_DTO_HomologacionCoberturaLegacy buscarPorID(Long id) throws Exception;
}
