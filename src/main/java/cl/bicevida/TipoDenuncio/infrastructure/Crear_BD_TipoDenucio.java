package cl.bicevida.TipoDenuncio.infrastructure;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Save_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.PuertoSalida_Crear_TipoDenucio;
import cl.bicevida.TipoDenuncio.utils.Mapper_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.persistence.Temporal;

@ApplicationScoped
@Slf4j
public class Crear_BD_TipoDenucio implements PuertoSalida_Crear_TipoDenucio {

    private final PanacheRepository_TipoDenucio reposity;

    private final Mapper_TipoDenucio mapper;

    public Crear_BD_TipoDenucio(PanacheRepository_TipoDenucio reposity, Mapper_TipoDenucio mapper) {
        this.reposity = reposity;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_TipoDenucio crear(Request_Save_DTO_TipoDenucio dto) {
        try {
            Entity_TipoDenucio entity = mapper.crearEntity(dto);
            reposity.persist(entity);
            return mapper.crearDTO(entity);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("Error al crear tipo denucio: " + e.getMessage());
        }

    }
}
