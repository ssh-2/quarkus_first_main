package cl.bicevida.HomologacionCoberturaLegacy.infrastructure;

import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.Entity_HomologacionCoberturaLegacy;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_HomologacionCoberturaLegacy implements PanacheRepository<Entity_HomologacionCoberturaLegacy> {
    public PanacheRepository_HomologacionCoberturaLegacy() {}
}
