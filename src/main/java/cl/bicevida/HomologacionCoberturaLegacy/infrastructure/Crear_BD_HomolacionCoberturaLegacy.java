package cl.bicevida.HomologacionCoberturaLegacy.infrastructure;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Save_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.Entity_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_Crear_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.utils.Mapper_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_HomolacionCoberturaLegacy implements PuertoSalida_Crear_HomologacionCoberturaLegacy {

    private final PanacheRepository_HomologacionCoberturaLegacy repository;

    private final Mapper_HomologacionCoberturaLegacy mapper;

    public Crear_BD_HomolacionCoberturaLegacy(PanacheRepository_HomologacionCoberturaLegacy repository, Mapper_HomologacionCoberturaLegacy mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_HomologacionCoberturaLegacy crear(Request_Save_DTO_HomologacionCoberturaLegacy dto) {
        Entity_HomologacionCoberturaLegacy entity = mapper.creatEntity(dto);
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
