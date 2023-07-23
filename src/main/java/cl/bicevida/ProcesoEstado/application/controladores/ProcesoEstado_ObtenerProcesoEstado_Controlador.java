package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.ObtenerProcesoEstado_PuertoSalida;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.ObtenerProcesoEstado_PuertoEntrada;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesoEstado_ObtenerProcesoEstado_Controlador implements ObtenerProcesoEstado_PuertoEntrada {

    private ObtenerProcesoEstado_PuertoSalida obtenerProcesoEstadoPuertoSalida;

    public ProcesoEstado_ObtenerProcesoEstado_Controlador(ObtenerProcesoEstado_PuertoSalida obtenerProcesoEstadoPuertoSalida) {
        this.obtenerProcesoEstadoPuertoSalida = obtenerProcesoEstadoPuertoSalida;
    }

    @Override
    public ProcesoEstado_Modelo obtenerProcesoEstado_PuertoEntrada(Long id) {
        return obtenerProcesoEstadoPuertoSalida.obtenerProcesoEstado_PuertoSalida(id);
    }
}
