package cl.bicevida.example;

import cl.bicevida.example.Persona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;

@Path("/personas")
@ApplicationScoped
public class PersonaRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Persona guardar(Persona persona) {
        entityManager.persist(persona);
        return persona;
    }

    public Persona buscarPorId(Long id) {
        return entityManager.find(Persona.class, id);
    }

    @Transactional
    public void actualizar(Persona persona) {
        entityManager.merge(persona);
    }

    @Transactional
    public void eliminar(Persona persona) {
        entityManager.remove(persona);
    }
}
