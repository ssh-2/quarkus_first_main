package cl.bicevida.Denuncio.infrastructure;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Denucio implements PanacheRepository<Entity_Denucio> {
    public PanacheRepository_Denucio() {}
}
