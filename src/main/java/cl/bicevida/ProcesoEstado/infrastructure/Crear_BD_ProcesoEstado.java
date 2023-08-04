package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Save_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Crear_ProcesoEstado;
import cl.bicevida.ProcesoEstado.utils.Mapper_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
@Slf4j
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
        try {
            Entity_ProcesoEstado entity = mapper.crearEntity(dto);
            repository.persist(entity);
            return mapper.crearDTO(entity);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al crear proceso estado: " + e.getMessage());
        }

    }
}
