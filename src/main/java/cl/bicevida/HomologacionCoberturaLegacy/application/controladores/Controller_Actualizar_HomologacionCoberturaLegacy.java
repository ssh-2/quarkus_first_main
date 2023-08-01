package cl.bicevida.HomologacionCoberturaLegacy.application.controladores;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Update_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoEntrada.PuertoEntrada_Actualizar_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_Actualizar_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Actualizar_HomologacionCoberturaLegacy implements PuertoEntrada_Actualizar_HomologacionCoberturaLegacy {

    private final PuertoSalida_Actualizar_HomologacionCoberturaLegacy puertoSalida;

    public Controller_Actualizar_HomologacionCoberturaLegacy(PuertoSalida_Actualizar_HomologacionCoberturaLegacy puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_HomologacionCoberturaLegacy actualizar(Long id, Request_Update_DTO_HomologacionCoberturaLegacy dtoIn) {
        return puertoSalida.actualizar(id, dtoIn);
    }
}
