package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.ActualizarProcesoEstado_PuertoSalida;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.ActualizarPrcesoEstado_PuertoEntrada;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesoEstado_ActualizarEstado_Controlador implements ActualizarPrcesoEstado_PuertoEntrada {

    private ActualizarProcesoEstado_PuertoSalida actualizarProcesoEstadoPuertoSalida;

    public ProcesoEstado_ActualizarEstado_Controlador(ActualizarProcesoEstado_PuertoSalida actualizarProcesoEstadoPuertoSalida) {
        this.actualizarProcesoEstadoPuertoSalida = actualizarProcesoEstadoPuertoSalida;
    }

    @Override
    public ProcesoEstado_Modelo actualizarProcesoEstado_PuertoEntrada(Long id, ProcesoEstado_Modelo precesoEstado) {
        return actualizarProcesoEstadoPuertoSalida.actualizarProcesoEstado_PuertoEntrada(id, precesoEstado);
    }
}
