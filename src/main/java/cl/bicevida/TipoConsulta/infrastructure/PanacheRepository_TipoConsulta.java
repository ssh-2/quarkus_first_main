package cl.bicevida.TipoConsulta.infrastructure;

import cl.bicevida.TipoConsulta.domain.modelo.Entity_TipoConsulta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_TipoConsulta implements PanacheRepository<Entity_TipoConsulta> {
    PanacheRepository_TipoConsulta() {}
}
