package cl.bicevida.TipoDenuncio.infrastructure;


import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_BuscarPorID_TipoDenucio;
import cl.bicevida.TipoDenuncio.utils.Mapper_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_TipoDenucio implements PuertoSalida_BuscarPorID_TipoDenucio {

    private final PanacheRepository_TipoDenucio repository;

    private final Mapper_TipoDenucio mapper;

    public BuscarPorID_BD_TipoDenucio(PanacheRepository_TipoDenucio repository, Mapper_TipoDenucio mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Response_DTO_TipoDenucio buscarPorID_PuertoSalida(Long id) throws Exception {
        try {
            Entity_TipoDenucio entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
