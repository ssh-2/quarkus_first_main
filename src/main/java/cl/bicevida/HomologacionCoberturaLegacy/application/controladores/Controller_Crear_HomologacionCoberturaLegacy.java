package cl.bicevida.HomologacionCoberturaLegacy.application.controladores;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Save_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoEntrada.PuertoEntrada_Crear_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_Crear_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_HomologacionCoberturaLegacy implements PuertoEntrada_Crear_HomologacionCoberturaLegacy {

    private final PuertoSalida_Crear_HomologacionCoberturaLegacy puertoSalida;

    public Controller_Crear_HomologacionCoberturaLegacy(PuertoSalida_Crear_HomologacionCoberturaLegacy puertoSalida) {
        this.puertoSalida = puertoSalida;
    }
    @Override
    public Response_DTO_HomologacionCoberturaLegacy crear(Request_Save_DTO_HomologacionCoberturaLegacy dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
