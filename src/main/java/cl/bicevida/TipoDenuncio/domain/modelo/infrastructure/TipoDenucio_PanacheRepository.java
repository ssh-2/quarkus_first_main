package cl.bicevida.TipoDenuncio.domain.modelo.infrastructure;

import cl.bicevida.TipoDenuncio.domain.modelo.domain.modelo.TipoDenuncio_Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDenucio_PanacheRepository implements PanacheRepository<TipoDenuncio_Modelo> {
    TipoDenucio_PanacheRepository() {}
}
