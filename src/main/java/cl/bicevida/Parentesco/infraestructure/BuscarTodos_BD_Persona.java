package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.utils.Mapper_Parentesco;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_BuscarTodos_Persona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Persona implements PuertoSalida_BuscarTodos_Persona {

    private final PanacheRepository_Persona repository;

    private final Mapper_Parentesco mapper;

    public BuscarTodos_BD_Persona(PanacheRepository_Persona repository, Mapper_Parentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_Persona> buscarTodos() {
        List<Entity_Persona> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
