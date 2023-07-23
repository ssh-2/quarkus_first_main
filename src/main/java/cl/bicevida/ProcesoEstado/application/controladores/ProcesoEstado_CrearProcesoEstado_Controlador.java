package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.CrearProcesoEstado_PuertoSalida;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.CrearProcesoEstado_PuertoEntrada;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesoEstado_CrearProcesoEstado_Controlador implements CrearProcesoEstado_PuertoEntrada {

    private CrearProcesoEstado_PuertoSalida crearProcesoEstadoPuertoSalida;

    public ProcesoEstado_CrearProcesoEstado_Controlador(CrearProcesoEstado_PuertoSalida crearProcesoEstadoPuertoSalida) {
        this.crearProcesoEstadoPuertoSalida = crearProcesoEstadoPuertoSalida;

    }

    @Override
    public ProcesoEstado_Modelo crearProcesoEstado_PuertoEntrada(ProcesoEstado_Modelo data_procesEstado) {
        return crearProcesoEstadoPuertoSalida.crearProcesoEstado_PuertoSalida(data_procesEstado);
    }
}
