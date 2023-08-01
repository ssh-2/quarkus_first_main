package cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;

public interface PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy {
    public Response_DTO_HomologacionCoberturaLegacy buscarPorID(Long id) throws Exception;
}
