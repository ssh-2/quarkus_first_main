package cl.bicevida.Canal.application.controladores;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoEntrada.PuertoEntrada_Crear_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Crear_Canal;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_CrearCanal_Controlador implements PuertoEntrada_Crear_Canal {

    private PuertoSalida_Crear_Canal crearCanalPuertoSalida;

    public Canal_CrearCanal_Controlador(PuertoSalida_Crear_Canal crearCanalPuertoSalida) {
        this.crearCanalPuertoSalida = crearCanalPuertoSalida;
    }

    @Override
    public Entity_Canal crearCanala_PuertoEntrada(Entity_Canal data_canal) {
        return crearCanalPuertoSalida.crearCanal_PuertoSalida(data_canal);
    }
}
