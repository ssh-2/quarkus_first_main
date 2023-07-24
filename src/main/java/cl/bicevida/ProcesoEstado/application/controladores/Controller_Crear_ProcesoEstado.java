package cl.bicevida.ProcesoEstado.application.controladores;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Crear_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertoEntrada.PuertoEntrada_Crear_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Crear_ProcesoEstado implements PuertoEntrada_Crear_ProcesoEstado {

    private PuertoSalida_Crear_ProcesoEstado crearProcesoEstadoPuertoSalida;

    public Controller_Crear_ProcesoEstado(PuertoSalida_Crear_ProcesoEstado crearProcesoEstadoPuertoSalida) {
        this.crearProcesoEstadoPuertoSalida = crearProcesoEstadoPuertoSalida;

    }

    @Override
    public Entity_ProcesoEstado crearProcesoEstado_PuertoEntrada(Entity_ProcesoEstado data_procesEstado) {
        return crearProcesoEstadoPuertoSalida.crearProcesoEstado_PuertoSalida(data_procesEstado);
    }
}
