package cl.bicevida.application.controladores;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosEntrada.CrearPais_PuertoEntrada;
import cl.bicevida.domain.puertosSalida.CrearPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Pais_CrearPais_Controlador implements CrearPais_PuertoEntrada {

    private CrearPais_PuertoSalida crearPais_puertoSalida;

    public Pais_CrearPais_Controlador(CrearPais_PuertoSalida crearPais_puertoSalida) {
        this.crearPais_puertoSalida = crearPais_puertoSalida;
    }

    @Override
    public Pais_Modelo crearPais_PuertoEntrada(Pais_Modelo data_pais){
        return crearPais_puertoSalida.crearPais_PuertoSalida(data_pais);
    }
}
