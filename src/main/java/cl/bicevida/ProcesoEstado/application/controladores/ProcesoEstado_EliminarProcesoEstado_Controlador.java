package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.puertaSalida.EliminarProcesoEstado_PuertoSalida;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.EliminarProcesoEstado_PuertoEntrada;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesoEstado_EliminarProcesoEstado_Controlador implements EliminarProcesoEstado_PuertoEntrada {

    private EliminarProcesoEstado_PuertoSalida eliminarProcesoEstadoPuertoSalida;

    public ProcesoEstado_EliminarProcesoEstado_Controlador(EliminarProcesoEstado_PuertoSalida eliminarProcesoEstadoPuertoSalida) {
        this.eliminarProcesoEstadoPuertoSalida = eliminarProcesoEstadoPuertoSalida;
    }

    @Override
    public void eliminarProcesoEstado_PuertoEntrada(Long id) {
        eliminarProcesoEstadoPuertoSalida.eliminarPrcesoEstado_PuertoSalida(id);
    }
}
