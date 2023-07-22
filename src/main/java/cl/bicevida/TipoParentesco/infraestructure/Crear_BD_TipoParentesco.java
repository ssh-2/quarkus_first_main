package cl.bicevida.TipoParentesco.infraestructure;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Save_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_Crear_TipoParentesco;
import cl.bicevida.TipoParentesco.utils.Mapper_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_TipoParentesco implements PuertoSalida_Crear_TipoParentesco {

    private final PanacheRepository_TipoParentesco repository;

    private final Mapper_TipoParentesco mapper;

    public Crear_BD_TipoParentesco(PanacheRepository_TipoParentesco repository, Mapper_TipoParentesco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_TipoParentesco crear(Request_Save_DTO_TipoParentesco dto) {
            Entity_TipoParentesco entity = mapper.crearEntity(dto);
            repository.persist(entity);
            return mapper.crearDTO(entity);
    }
}
