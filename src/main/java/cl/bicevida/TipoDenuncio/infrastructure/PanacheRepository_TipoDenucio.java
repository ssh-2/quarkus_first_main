package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_TipoDenucio implements PanacheRepository<Entity_TipoDenucio> {
    PanacheRepository_TipoDenucio() {}
}
