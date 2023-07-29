package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Liquidador implements PanacheRepository<Entity_Liquidador> {
    public PanacheRepository_Liquidador(){}
}
