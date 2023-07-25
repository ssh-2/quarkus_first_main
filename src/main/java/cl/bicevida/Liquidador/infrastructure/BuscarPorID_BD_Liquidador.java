package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_BuscarPorID_Liquidador;
import cl.bicevida.Liquidador.utils.Mapper_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_Liquidador implements PuertoSalida_BuscarPorID_Liquidador {


    private final PanacheRepository_Liquidador repository;
    private final Mapper_Liquidador mapper;

    public BuscarPorID_BD_Liquidador(PanacheRepository_Liquidador repository, Mapper_Liquidador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_Liquidador buscarPorID(Long id) throws Exception {
        log.info(CONSULTANDO_ID_INFRAESTRUCTURE + id);
        try {
            Entity_Liquidador entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
