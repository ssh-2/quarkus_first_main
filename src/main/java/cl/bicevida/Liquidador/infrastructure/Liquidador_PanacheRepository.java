package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Liquidador_PanacheRepository implements PanacheRepository<Liquidador_Modelo> {
    public Liquidador_PanacheRepository(){}
}
