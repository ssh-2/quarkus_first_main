package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Canal implements PanacheRepository<Entity_Canal> {
    public PanacheRepository_Canal() {}
}
