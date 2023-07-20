package cl.bicevida.Canal.domain.puertoSalida;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ObtenerTodosCanal_PuertoSalida {
    public List<Canal_Modelo> obtenerTodosCanal_PuertoSalida();
}
