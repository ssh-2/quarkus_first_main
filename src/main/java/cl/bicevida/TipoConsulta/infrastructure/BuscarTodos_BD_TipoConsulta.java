package cl.bicevida.TipoConsulta.infrastructure;

import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.modelo.Entity_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoConsulta;
import cl.bicevida.TipoConsulta.utils.Mapper_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_TipoConsulta implements PuertoSalida_BuscarTodos_TipoConsulta {

    private final PanacheRepository_TipoConsulta repository;

    private final Mapper_TipoConsulta mapper;

    public BuscarTodos_BD_TipoConsulta(PanacheRepository_TipoConsulta repository, Mapper_TipoConsulta mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_TipoConsulta> buscarTodos() {
        List<Entity_TipoConsulta> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
