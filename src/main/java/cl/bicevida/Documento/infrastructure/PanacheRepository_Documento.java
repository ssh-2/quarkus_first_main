package cl.bicevida.Documento.infrastructure;

import cl.bicevida.Documento.domain.modelo.Entity_Documento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRepository_Documento implements PanacheRepository<Entity_Documento> {
    public PanacheRepository_Documento() {}
}
