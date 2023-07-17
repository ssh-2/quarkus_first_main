package cl.bicevida.application.controladores;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosEntrada.ActualizarPais_PuertoEntrada;
import cl.bicevida.domain.puertosSalida.ActualizarPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Pais_ActualizarPais_Controlador implements ActualizarPais_PuertoEntrada {

    private ActualizarPais_PuertoSalida actualizarPais_puertoSalida;

    public Pais_ActualizarPais_Controlador(ActualizarPais_PuertoSalida actualizarPais_puertoSalida) {
        this.actualizarPais_puertoSalida = actualizarPais_puertoSalida;
    }

    public Pais_Modelo actualizarPais_PuertoEntrada(long id, Pais_Modelo pais){
        return actualizarPais_puertoSalida.actualizarPais_PuertoSalida(id, pais);
    }
}
