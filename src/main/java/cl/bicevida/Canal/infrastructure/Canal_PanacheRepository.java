package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_PanacheRepository implements PanacheRepository<Canal_Modelo> {
    public Canal_PanacheRepository() {}
}
