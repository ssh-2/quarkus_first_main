package cl.bicevida.HomologacionCoberturaLegacy.infrastructure;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.Entity_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_BuscarTodos_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.utils.Mapper_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_HomologacionCoberturaLegacy implements PuertoSalida_BuscarTodos_HomologacionCoberturaLegacy {

    private final PanacheRepository_HomologacionCoberturaLegacy repository;

    private final Mapper_HomologacionCoberturaLegacy mapper;

    public BuscarTodos_BD_HomologacionCoberturaLegacy(PanacheRepository_HomologacionCoberturaLegacy repository, Mapper_HomologacionCoberturaLegacy mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Response_DTO_HomologacionCoberturaLegacy> buscarTodos() {
        List<Entity_HomologacionCoberturaLegacy> entities = repository.listAll();
        return mapper.crearDTO(entities);
    }
}
