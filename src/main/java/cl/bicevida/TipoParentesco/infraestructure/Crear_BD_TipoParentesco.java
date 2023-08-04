package cl.bicevida.TipoParentesco.infraestructure;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Save_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.puertoSalida.PuertoSalida_Crear_TipoParentesco;
import cl.bicevida.TipoParentesco.utils.Mapper_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
@Slf4j
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
        try {
            Entity_TipoParentesco entity = mapper.crearEntity(dto);
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
            throw new InternalServerErrorException("Error al crear tipo parentesco: " + e.getMessage());
        }

    }
}
