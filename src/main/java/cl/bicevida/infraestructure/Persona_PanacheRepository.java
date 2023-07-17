package cl.bicevida.infraestructure;

import cl.bicevida.domain.modelo.Persona_Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Persona_PanacheRepository  implements PanacheRepository<Persona_Modelo> {
    public Persona_PanacheRepository() {}

}
