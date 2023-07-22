package cl.bicevida.TipoPersona.infraestructure;

import cl.bicevida.TipoPersona.domain.DTO.Request_Update_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import cl.bicevida.TipoPersona.domain.puertoSalida.PuertoSalida_Actualizar_TipoPersona;
import cl.bicevida.TipoPersona.utils.Mapper_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.LocalDateTime;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_TipoPersona implements PuertoSalida_Actualizar_TipoPersona {

    private final PanacheRepository_TipoPersona repository;

    private final Mapper_TipoPersona mapper;

    public Actualizar_BD_TipoPersona(PanacheRepository_TipoPersona repository, Mapper_TipoPersona mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Response_DTO_TipoPersona actualizar(Long id, Request_Update_DTO_TipoPersona dto) {
        Entity_TipoPersona entity = repository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
        entity.setNombre(dto.getNombre());
        entity.setUsuarioActualizacion(dto.getUsuarioActualizacion());
        entity.setFechaActualizacion(LocalDateTime.now());
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
