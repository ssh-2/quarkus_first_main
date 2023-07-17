package cl.bicevida.domain.puertosSalida;

import cl.bicevida.domain.modelo.Pais_Modelo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ObtenerTodosPais_PuertoSalida {
    public List<Pais_Modelo> obtenerTodosPais_PuertoSalida();
}
