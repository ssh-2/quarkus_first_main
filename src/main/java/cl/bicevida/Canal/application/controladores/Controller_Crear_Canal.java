package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.DTO.Request_Save_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_Crear_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Crear_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_Canal implements PuertoEntrada_Crear_Canal {

    private final PuertoSalida_Crear_Canal puertoSalida;

    public Controller_Crear_Canal(PuertoSalida_Crear_Canal puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Canal crear(Request_Save_DTO_Canal dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
