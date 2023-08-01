package cl.bicevida.Banco.infrastructure;

import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Banco implements PanacheRepository<Entity_Banco> {
    public PanacheRepository_Banco() {}
}
