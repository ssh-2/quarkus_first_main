package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Actualizar_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_Actualizar_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Acutalizar_ProcesoEstado implements PuertoEntrada_Actualizar_ProcesoEstado {

    private PuertoSalida_Actualizar_ProcesoEstado actualizarProcesoEstadoPuertoSalida;

    public Controller_Acutalizar_ProcesoEstado(PuertoSalida_Actualizar_ProcesoEstado actualizarProcesoEstadoPuertoSalida) {
        this.actualizarProcesoEstadoPuertoSalida = actualizarProcesoEstadoPuertoSalida;
    }

    @Override
    public Entity_ProcesoEstado actualizarProcesoEstado_PuertoEntrada(Long id, Entity_ProcesoEstado precesoEstado) {
        return actualizarProcesoEstadoPuertoSalida.actualizarProcesoEstado_PuertoEntrada(id, precesoEstado);
    }
}
