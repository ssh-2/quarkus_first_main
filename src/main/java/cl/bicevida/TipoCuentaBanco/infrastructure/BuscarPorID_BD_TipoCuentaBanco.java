package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.utils.Mapper_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_TipoCuentaBanco implements PuertoSalida_BuscarPorID_TipoCuentaBanco {

    private final PanacheRepository_TipoCuentaBanco repository;

    private final Mapper_TipoCuentaBanco mapper;

    public BuscarPorID_BD_TipoCuentaBanco(PanacheRepository_TipoCuentaBanco repository, Mapper_TipoCuentaBanco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_TipoCuentaBanco buscarPorID(Long id) throws Exception {
        try {
            Entity_TipoCuentaBanco entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
