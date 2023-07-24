package cl.bicevida.TipoConsulta.infrastructure;

import cl.bicevida.TipoConsulta.domain.modelo.TipoConsulta_Modelo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class TipoConsulta_PanacheRepository implements PanacheRepository<TipoConsulta_Modelo> {
    TipoConsulta_PanacheRepository() {

    }
}
