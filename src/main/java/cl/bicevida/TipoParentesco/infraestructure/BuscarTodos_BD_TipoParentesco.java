package cl.bicevida.TipoParentesco.infraestructure;

import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoParentesco;
import cl.bicevida.TipoParentesco.utils.Mapper_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_TipoParentesco implements PuertoSalida_BuscarTodos_TipoParentesco {

    private final PanacheRepository_TipoParentesco repository;

    private final Mapper_TipoParentesco mapper;

    public BuscarTodos_BD_TipoParentesco(PanacheRepository_TipoParentesco repository, Mapper_TipoParentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_TipoParentesco> buscarTodos() {
        List<Entity_TipoParentesco> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
