package cl.bicevida.TipoParentesco.infraestructure;

import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoParentesco;
import cl.bicevida.TipoParentesco.utils.Mapper_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_DB_TipoParentesco implements PuertoSalida_BuscarPorID_TipoParentesco {

    private final PanacheRepository_TipoParentesco repository;

    private final Mapper_TipoParentesco mapper;

    public BuscarPorID_DB_TipoParentesco(PanacheRepository_TipoParentesco repository, Mapper_TipoParentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_TipoParentesco buscarPorID(Long id) {
        try {
            Entity_TipoParentesco entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
