package cl.bicevida.TipoPersona.infraestructure;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_BuscarTodos_TipoPersona;
import cl.bicevida.TipoPersona.utils.Mapper_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_TipoPersona implements PuertoSalida_BuscarTodos_TipoPersona {

    private final PanacheRepository_TipoPersona repository;

    private final Mapper_TipoPersona mapper;

    public BuscarTodos_BD_TipoPersona(PanacheRepository_TipoPersona repository, Mapper_TipoPersona mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_TipoPersona> buscarTodos() {
        List<Entity_TipoPersona> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
