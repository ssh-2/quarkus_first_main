package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Save_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Crear_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.utils.Mapper_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
@Slf4j
public class Crear_BD_TipoCuentaBanco implements PuertoSalida_Crear_TipoCuentaBanco {

    private final PanacheRepository_TipoCuentaBanco repository;

    private final Mapper_TipoCuentaBanco mapper;

    public Crear_BD_TipoCuentaBanco(PanacheRepository_TipoCuentaBanco repository, Mapper_TipoCuentaBanco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_TipoCuentaBanco crear(Request_Save_DTO_TipoCuentaBanco dto) {
        try {
            Entity_TipoCuentaBanco entity = mapper.crearEntity(dto);
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
            throw new InternalServerErrorException("Error al crear tipo cuenta banco: " + e.getMessage());
        }

    }
}
