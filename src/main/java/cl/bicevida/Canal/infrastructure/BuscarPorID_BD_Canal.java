package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_BusacrPorID_Canal;
import cl.bicevida.Canal.utils.Mapper_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_Canal implements PuertoSalida_BusacrPorID_Canal {

    private final PanacheRepository_Canal repository;

    private final Mapper_Canal mapper;

    public BuscarPorID_BD_Canal(PanacheRepository_Canal repository, Mapper_Canal mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Response_DTO_Canal buscarPorID(Long id) {
        try {
            Entity_Canal entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw  new NotFoundException(e.getMessage());
        }
    }
}
