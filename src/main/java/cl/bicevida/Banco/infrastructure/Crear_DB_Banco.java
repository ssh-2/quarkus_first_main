package cl.bicevida.Banco.infrastructure;

import cl.bicevida.Banco.domain.DTO.Request_Save_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_Crear_Banco;
import cl.bicevida.Banco.utils.Mapper_Banco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
@Slf4j
public class Crear_DB_Banco implements PuertoSalida_Crear_Banco {

    private final PanacheRepository_Banco repository;

    private final Mapper_Banco mapper;

    public Crear_DB_Banco(PanacheRepository_Banco repository, Mapper_Banco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    @Retry(maxRetries = 3, delay = 3000)
    public Response_DTO_Banco crear(Request_Save_DTO_Banco dto) {
        try {
            Entity_Banco entity = mapper.crearEntity(dto);
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
            throw new InternalServerErrorException("Error al crear Banco: " + e.getMessage());
        }

    }
}
