package cl.bicevida.TipoPersona.infraestructure;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoPersona;
import cl.bicevida.TipoPersona.utils.Mapper_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_DB_TipoPersona implements PuertoSalida_BuscarPorID_TipoPersona {

    private final PanacheRepository_TipoPersona repository;

    private final Mapper_TipoPersona mapper;

    public BuscarPorID_DB_TipoPersona(PanacheRepository_TipoPersona repository, Mapper_TipoPersona mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_TipoPersona buscarPorID(Long id) {
        log.info(CONSULTANDO_ID_INFRAESTRUCTURE + "id");
        try {
            Entity_TipoPersona entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
