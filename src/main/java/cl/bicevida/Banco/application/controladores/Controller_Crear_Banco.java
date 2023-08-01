package cl.bicevida.Banco.application.controladores;

import cl.bicevida.Banco.domain.DTO.Request_Save_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.puertoEntrada.PuertoEntrada_Crear_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_Crear_Banco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_Banco implements PuertoEntrada_Crear_Banco {

    private final PuertoSalida_Crear_Banco puertoSalida;

    public Controller_Crear_Banco(PuertoSalida_Crear_Banco puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Banco crear(Request_Save_DTO_Banco dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
