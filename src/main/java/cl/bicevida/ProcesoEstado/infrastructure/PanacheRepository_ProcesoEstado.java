package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_ProcesoEstado implements PanacheRepository<Entity_ProcesoEstado> {
    public PanacheRepository_ProcesoEstado() {}
}
