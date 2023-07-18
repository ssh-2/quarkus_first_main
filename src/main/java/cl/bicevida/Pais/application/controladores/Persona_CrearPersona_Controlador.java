package cl.bicevida.application.controladores;


import cl.bicevida.domain.modelo.Persona_Modelo;
import cl.bicevida.domain.puertosEntrada.CrearPersona_PuertoEntrada;
import cl.bicevida.domain.puertosSalida.CrearPersona_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Persona_CrearPersona_Controlador implements CrearPersona_PuertoEntrada {

    private CrearPersona_PuertoSalida crearPersona_puertoSalida;

    public Persona_CrearPersona_Controlador(CrearPersona_PuertoSalida crearPersona_puertoSalida) {
        this.crearPersona_puertoSalida = crearPersona_puertoSalida;
    }

    @Override
    public Persona_Modelo crearPersona_PuertoEntrada(Persona_Modelo data_persona) {
        return crearPersona_puertoSalida.crearPersona_PuertoSalida(data_persona);
    }
}
