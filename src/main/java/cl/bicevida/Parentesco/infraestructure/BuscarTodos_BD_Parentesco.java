package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.modelo.Entity_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_BuscarTodos_Parentesco;
import cl.bicevida.Parentesco.utils.Mapper_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Parentesco implements PuertoSalida_BuscarTodos_Parentesco {

    private final PanacheRepository_Parentesco repository;

    private final Mapper_Parentesco mapper;

    public BuscarTodos_BD_Parentesco(PanacheRepository_Parentesco repository, Mapper_Parentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_Parentesco> buscarTodos() {
        List<Entity_Parentesco> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
