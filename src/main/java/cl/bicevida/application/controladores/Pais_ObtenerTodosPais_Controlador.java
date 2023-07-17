package cl.bicevida.application.controladores;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosEntrada.ObtenerTodosPais_PuertoEntrada;
import cl.bicevida.domain.puertosSalida.ObtenerTodosPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Pais_ObtenerTodosPais_Controlador implements ObtenerTodosPais_PuertoEntrada {

    private ObtenerTodosPais_PuertoSalida obtenerTodosPais_puertoSalida;

    public Pais_ObtenerTodosPais_Controlador(ObtenerTodosPais_PuertoSalida obtenerTodosPais_puertoSalida) {
        this.obtenerTodosPais_puertoSalida = obtenerTodosPais_puertoSalida;
    }

    @Override
    public List<Pais_Modelo> obtenerTodosPais_PuertoEntrada(){
        return obtenerTodosPais_puertoSalida.obtenerTodosPais_PuertoSalida();
    }
}
