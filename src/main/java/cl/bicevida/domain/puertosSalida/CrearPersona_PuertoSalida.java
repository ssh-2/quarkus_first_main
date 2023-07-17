package cl.bicevida.domain.puertosSalida;

import cl.bicevida.domain.modelo.Persona_Modelo;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

public interface CrearPersona_PuertoSalida {
    Persona_Modelo crearPersona_PuertoSalida(Persona_Modelo persona);
}
