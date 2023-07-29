package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarTodos_ProcesoEstado;
import cl.bicevida.ProcesoEstado.utils.Mapper_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_ProcesoEstado implements PuertoSalida_BuscarTodos_ProcesoEstado {

    private final PanacheRepository_ProcesoEstado repository;

    private final Mapper_ProcesoEstado mapper;

    public BuscarTodos_BD_ProcesoEstado(PanacheRepository_ProcesoEstado repository, Mapper_ProcesoEstado mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_ProcesoEstado> buscarTodos() {
        List<Entity_ProcesoEstado> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
