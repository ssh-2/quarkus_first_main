package cl.bicevida.HomologacionCoberturaLegacy.infrastructure;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.Entity_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.utils.Mapper_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_HomologacionCoberturaLegacy implements PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy {

    private final PanacheRepository_HomologacionCoberturaLegacy repository;

    private final Mapper_HomologacionCoberturaLegacy mapper;

    public BuscarPorID_BD_HomologacionCoberturaLegacy(PanacheRepository_HomologacionCoberturaLegacy repository, Mapper_HomologacionCoberturaLegacy mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_HomologacionCoberturaLegacy buscarPorID(Long id) throws Exception {
        try {
            Entity_HomologacionCoberturaLegacy entity = repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
