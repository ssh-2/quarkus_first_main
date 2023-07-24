package cl.bicevida.Persona.infraestructure;

import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Persona implements PanacheRepository<Entity_Persona> {

    public PanacheRepository_Persona() {
    }
}
