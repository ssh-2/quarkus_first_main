package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesoEstado_PanacheRepository implements PanacheRepository<ProcesoEstado_Modelo> {
    public ProcesoEstado_PanacheRepository() {}
}
