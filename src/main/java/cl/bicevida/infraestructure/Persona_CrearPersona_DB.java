package cl.bicevida.infraestructure;


import cl.bicevida.domain.modelo.Persona_Modelo;
import cl.bicevida.domain.puertosSalida.CrearPersona_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Persona_CrearPersona_DB implements CrearPersona_PuertoSalida {

    @Inject
    Persona_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Persona_Modelo crearPersona_PuertoSalida(Persona_Modelo persona) {
        repository.persist(persona);
        return repository.findById(persona.id);
    }

}
