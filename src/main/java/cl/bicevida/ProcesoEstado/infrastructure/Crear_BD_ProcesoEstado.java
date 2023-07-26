package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Save_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Crear_ProcesoEstado;
import cl.bicevida.ProcesoEstado.utils.Mapper_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_ProcesoEstado implements PuertoSalida_Crear_ProcesoEstado {

    private final PanacheRepository_ProcesoEstado repository;

    private final Mapper_ProcesoEstado mapper;

    public Crear_BD_ProcesoEstado(PanacheRepository_ProcesoEstado repository, Mapper_ProcesoEstado mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_ProcesoEstado crear(Request_Save_DTO_ProcesoEstado dto) {
        Entity_ProcesoEstado entity = mapper.crearEntity(dto);
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
