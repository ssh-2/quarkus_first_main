package cl.bicevida.Banco.infrastructure;

import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_BuscarPorID_Banco;
import cl.bicevida.Banco.utils.Mapper_Banco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_Banco implements PuertoSalida_BuscarPorID_Banco {

    private final PanacheRepository_Banco repository;

    private final Mapper_Banco mapper;

    public BuscarPorID_BD_Banco(PanacheRepository_Banco repository, Mapper_Banco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_Banco buscarPorID(Long id) throws Exception {
        try {
            Entity_Banco entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw  new NotFoundException(e.getMessage());
        }
    }
}
