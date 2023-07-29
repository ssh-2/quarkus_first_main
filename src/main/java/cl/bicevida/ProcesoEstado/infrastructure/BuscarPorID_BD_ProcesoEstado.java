package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_BuscarPorID_ProcesoEstado;
import cl.bicevida.ProcesoEstado.utils.Mapper_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_ProcesoEstado implements PuertoSalida_BuscarPorID_ProcesoEstado {

    private final PanacheRepository_ProcesoEstado repository;
    private final Mapper_ProcesoEstado mapper;

    public BuscarPorID_BD_ProcesoEstado(PanacheRepository_ProcesoEstado repository, Mapper_ProcesoEstado mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Response_DTO_ProcesoEstado buscarPorID(Long id) throws Exception {
        try {
            Entity_ProcesoEstado entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
