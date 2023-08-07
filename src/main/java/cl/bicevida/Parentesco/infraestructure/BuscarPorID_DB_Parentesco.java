package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.modelo.Entity_Parentesco;
import cl.bicevida.Parentesco.domain.puertoSalida.PuertoSalida_BuscarPorID_Parentesco;
import cl.bicevida.Parentesco.utils.Mapper_Parentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_DB_Parentesco implements PuertoSalida_BuscarPorID_Parentesco {

    private final PanacheRepository_Parentesco repository;

    private final Mapper_Parentesco mapper;

    public BuscarPorID_DB_Parentesco(PanacheRepository_Parentesco repository, Mapper_Parentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_Parentesco buscarPorID(Long id) {
        try {
            Entity_Parentesco entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));

            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
