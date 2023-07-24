package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarPorID_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_BuscarPorID_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_BuscarPorID_ProcesoEstado implements PuertoEntrada_BuscarPorID_ProcesoEstado {

    private PuertoSalida_BuscarPorID_ProcesoEstado obtenerProcesoEstadoPuertoSalida;

    public Controller_BuscarPorID_ProcesoEstado(PuertoSalida_BuscarPorID_ProcesoEstado obtenerProcesoEstadoPuertoSalida) {
        this.obtenerProcesoEstadoPuertoSalida = obtenerProcesoEstadoPuertoSalida;
    }

    @Override
    public Entity_ProcesoEstado obtenerProcesoEstado_PuertoEntrada(Long id) {
        return obtenerProcesoEstadoPuertoSalida.obtenerProcesoEstado_PuertoSalida(id);
    }
}
