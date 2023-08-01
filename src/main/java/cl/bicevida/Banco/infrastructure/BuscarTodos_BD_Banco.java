package cl.bicevida.Banco.infrastructure;

import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_BuscarTodos_Banco;
import cl.bicevida.Banco.utils.Mapper_Banco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Banco implements PuertoSalida_BuscarTodos_Banco {

    private final PanacheRepository_Banco repository;

    private final Mapper_Banco mapper;

    public BuscarTodos_BD_Banco(PanacheRepository_Banco repository, Mapper_Banco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_Banco> buscarTodos() {
        List<Entity_Banco> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
