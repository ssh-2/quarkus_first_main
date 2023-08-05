package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.utils.Mapper_Parentesco;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_BuscarPorID_Persona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_DB_Persona implements PuertoSalida_BuscarPorID_Persona {

    private final PanacheRepository_Persona repository;

    private final Mapper_Parentesco mapper;

    public BuscarPorID_DB_Persona(PanacheRepository_Persona repository, Mapper_Parentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_Persona buscarPorID(Long id) {
        try {
            Entity_Persona entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
