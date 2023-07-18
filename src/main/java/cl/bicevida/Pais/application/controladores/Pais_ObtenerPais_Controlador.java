package cl.bicevida.application.controladores;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosEntrada.ObtenerPais_PuertoEntrada;
import cl.bicevida.domain.puertosSalida.ObtenerPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Pais_ObtenerPais_Controlador implements ObtenerPais_PuertoEntrada {

    private ObtenerPais_PuertoSalida obtenerPais_puertoSalida;

    public Pais_ObtenerPais_Controlador(ObtenerPais_PuertoSalida obtenerPais_puertoSalida) {
        this.obtenerPais_puertoSalida = obtenerPais_puertoSalida;
    }

    @Override
    public Pais_Modelo obtenerPais_PuertoEntrada(long id){
        return obtenerPais_puertoSalida.obtenerPais_PuertoSalida(id);
    }
}
