package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_TipoCuentaBanco implements PanacheRepository<Entity_TipoCuentaBanco> {
    public PanacheRepository_TipoCuentaBanco(){}
}
