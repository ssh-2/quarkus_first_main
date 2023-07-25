package cl.bicevida.Liquidador.application.controladores;


import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoEntrada.PuertoEntrada_Crear_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Crear_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_Liquidador implements PuertoEntrada_Crear_Liquidador {

    private final PuertoSalida_Crear_Liquidador puertoSalida;

    public Controller_Crear_Liquidador(PuertoSalida_Crear_Liquidador puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public Response_DTO_Liquidador crear(Request_Save_DTO_Liquidador dtoIn) {
        return puertoSalida.crear(dtoIn);
    }
}
