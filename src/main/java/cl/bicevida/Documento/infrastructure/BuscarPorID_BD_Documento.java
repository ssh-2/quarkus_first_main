package cl.bicevida.Documento.infrastructure;

import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.modelo.Entity_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_BuscarPorID_Documento;
import cl.bicevida.Documento.utils.Mapper_Documento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class BuscarPorID_BD_Documento implements PuertoSalida_BuscarPorID_Documento {

    private final PanacheRepository_Documento repository;

    private final Mapper_Documento mapper;

    public BuscarPorID_BD_Documento(PanacheRepository_Documento repository, Mapper_Documento mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response_DTO_Documento buscarPorID(Long id) throws Exception {
        try {
            Entity_Documento entity = repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            return mapper.crearDTO(entity);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
