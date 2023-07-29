package cl.bicevida.TipoConsulta.infrastructure;

import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.modelo.Entity_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoConsulta;
import cl.bicevida.TipoConsulta.utils.Mapper_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_TipoConsulta implements PuertoSalida_BuscarPorID_TipoConsulta {

    private final PanacheRepository_TipoConsulta repository;

    private final Mapper_TipoConsulta mapper;

    public BuscarPorID_BD_TipoConsulta(PanacheRepository_TipoConsulta repository, Mapper_TipoConsulta mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_TipoConsulta buscarPorID(Long id) {
        try {
            Entity_TipoConsulta entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
