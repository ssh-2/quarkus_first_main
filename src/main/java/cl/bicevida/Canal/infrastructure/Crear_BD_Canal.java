package cl.bicevida.Canal.infrastructure;

import cl.bicevida.Canal.domain.DTO.Request_Save_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Crear_Canal;
import cl.bicevida.Canal.utils.Mapper_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
@Slf4j
public class Crear_BD_Canal implements PuertoSalida_Crear_Canal {

    private final PanacheRepository_Canal repository;

    private final Mapper_Canal mapper;

    public Crear_BD_Canal(PanacheRepository_Canal repository, Mapper_Canal mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_Canal crear(Request_Save_DTO_Canal dto) {
        try {
            Entity_Canal entity = mapper.crearEntity(dto);
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
            throw new InternalServerErrorException("Error al crear un Canal: " + e.getMessage());
        }
    }
}
