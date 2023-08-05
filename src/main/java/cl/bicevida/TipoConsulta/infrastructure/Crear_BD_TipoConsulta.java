package cl.bicevida.TipoConsulta.infrastructure;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Save_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.modelo.Entity_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.puertoSalida.PuertoSalida_Crear_TipoConsulta;
import cl.bicevida.TipoConsulta.utils.Mapper_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
@Slf4j
public class Crear_BD_TipoConsulta implements PuertoSalida_Crear_TipoConsulta {

    private final PanacheRepository_TipoConsulta repository;

    private final Mapper_TipoConsulta mapper;

    public Crear_BD_TipoConsulta(PanacheRepository_TipoConsulta repository, Mapper_TipoConsulta mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_TipoConsulta crear(Request_Save_DTO_TipoConsulta dto) {
        try {
            Entity_TipoConsulta entity = mapper.crearEntity(dto);
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
            throw new InternalServerErrorException("Error al crear tipo consulta: " + e.getMessage());
        }

    }
}
