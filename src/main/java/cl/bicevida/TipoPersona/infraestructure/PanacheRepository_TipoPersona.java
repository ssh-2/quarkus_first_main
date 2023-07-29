package cl.bicevida.TipoPersona.infraestructure;

import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_TipoPersona implements PanacheRepository<Entity_TipoPersona> {

    public PanacheRepository_TipoPersona() {
    }

}
