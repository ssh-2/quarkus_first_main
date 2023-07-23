package cl.bicevida.TipoPersona.infraestructure;

import cl.bicevida.TipoPersona.domain.DTO.Request_Save_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_Crear_TipoPersona;
import cl.bicevida.TipoPersona.utils.Mapper_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_TipoPersona implements PuertoSalida_Crear_TipoPersona {

    private final PanacheRepository_TipoPersona repository;

    private final Mapper_TipoPersona mapper;

    public Crear_BD_TipoPersona( PanacheRepository_TipoPersona repository, Mapper_TipoPersona mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_TipoPersona crear(Request_Save_DTO_TipoPersona dto) {

            Entity_TipoPersona entity = mapper.crearEntity(dto);
            repository.persist(entity);
            return mapper.crearDTO(entity);

    }
}
