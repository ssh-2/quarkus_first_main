package cl.bicevida.TipoParentesco.infraestructure;

import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_TipoParentesco implements PanacheRepository<Entity_TipoParentesco> {

    public PanacheRepository_TipoParentesco() {
    }
}
