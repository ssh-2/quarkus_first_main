package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.utils.Mapper_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;


@ApplicationScoped
public class BuscarTodos_BD_TipoCuentaBanco implements PuertoSalida_BuscarTodos_TipoCuentaBanco {

    private final PanacheRepository_TipoCuentaBanco repository;

    private final Mapper_TipoCuentaBanco mapper;

    public BuscarTodos_BD_TipoCuentaBanco(PanacheRepository_TipoCuentaBanco repository, Mapper_TipoCuentaBanco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_TipoCuentaBanco> buscarTodos() {
        List<Entity_TipoCuentaBanco> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
