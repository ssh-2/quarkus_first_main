package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Crear_Liquidador;
import cl.bicevida.Liquidador.utils.Mapper_Liquidador;
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
public class Crear_BD_Liquidador implements PuertoSalida_Crear_Liquidador {

    private final PanacheRepository_Liquidador repository;

    private final Mapper_Liquidador mapper;

    public Crear_BD_Liquidador(PanacheRepository_Liquidador repository, Mapper_Liquidador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_Liquidador crear(Request_Save_DTO_Liquidador dto) {
        try {
            Entity_Liquidador entity = mapper.crearEntity(dto);
            repository.persist(entity);
            return mapper.crearDTO(entity);
        }catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al crear un liquidador: " + e.getMessage());
        }

    }
}
