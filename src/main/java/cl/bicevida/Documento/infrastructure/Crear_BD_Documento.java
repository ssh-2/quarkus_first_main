package cl.bicevida.Documento.infrastructure;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import cl.bicevida.Denuncio.infrastructure.PanacheRepository_Denucio;
import cl.bicevida.Documento.domain.DTO.Request_Save_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.modelo.Entity_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_Crear_Documento;
import cl.bicevida.Documento.utils.Mapper_Documento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Crear_BD_Documento implements PuertoSalida_Crear_Documento {

    private final PanacheRepository_Documento repository;

    private final PanacheRepository_Denucio repositoryDenucio;

    private final Mapper_Documento mapper;

    public Crear_BD_Documento(PanacheRepository_Documento repository, PanacheRepository_Denucio repositoryDenucio, Mapper_Documento mapper) {
        this.repository = repository;
        this.repositoryDenucio = repositoryDenucio;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Override
    public Response_DTO_Documento crear(Request_Save_DTO_Documento dto) {
        log.info("[POST] intentando crear un documento");

        try {
            Long idDenucio = 1L;
            Entity_Denucio entityDenucio = repositoryDenucio.findByIdOptional(idDenucio)
                    .orElseThrow(() -> new NotFoundException("En la tabla Denucio " + NOT_FOUND_BY_ID + idDenucio));

            Entity_Documento entity = mapper.crearEntity(dto, entityDenucio);

            repository.persist(entity);
            return mapper.crearDTO(entity);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            throw new BadRequestException(e.getMessage());
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            log.error("Error al crear un Documento: " + e.getMessage());
            throw new InternalServerErrorException("Error al crear un Documento: " + e.getMessage());
        }
    }
}
