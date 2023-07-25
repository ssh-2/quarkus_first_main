package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarTodos_Liquidador;
import cl.bicevida.Liquidador.utils.Mapper_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Liquidador implements PuertoSalida_BuscarTodos_Liquidador {

    private final PanacheRepository_Liquidador repository;

    private final Mapper_Liquidador mapper;

    public BuscarTodos_BD_Liquidador(PanacheRepository_Liquidador repository, Mapper_Liquidador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_Liquidador> buscarTodos() {
        List<Entity_Liquidador> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
