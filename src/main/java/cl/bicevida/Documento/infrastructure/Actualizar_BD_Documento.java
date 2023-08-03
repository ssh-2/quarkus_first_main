package cl.bicevida.Documento.infrastructure;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import cl.bicevida.Denuncio.infrastructure.PanacheRepository_Denucio;
import cl.bicevida.Documento.domain.DTO.Request_Update_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.modelo.Entity_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_Actualizar_Documento;
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
public class Actualizar_BD_Documento implements PuertoSalida_Actualizar_Documento {

    private final PanacheRepository_Documento repository;

    private final PanacheRepository_Denucio repositoryDenucio;

    private final Mapper_Documento mapper;


    public Actualizar_BD_Documento(PanacheRepository_Documento repository, PanacheRepository_Denucio repositoryDenucio, Mapper_Documento mapper) {
        this.repository = repository;
        this.repositoryDenucio = repositoryDenucio;
        this.mapper = mapper;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public Response_DTO_Documento actualizar(Long id, Request_Update_DTO_Documento dto) {
        log.info("[PUT] intentando modificar un documento con id: " + id);
        Long idDenucio = 1L;
        Entity_Denucio entityDenucio = repositoryDenucio.findByIdOptional(idDenucio)
                .orElseThrow(() -> new NotFoundException("En la tabla Denucio " + NOT_FOUND_BY_ID + idDenucio));

        Entity_Documento entity = repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("En la tabla Documento " + NOT_FOUND_BY_ID + id));

        Entity_Documento documentoModificado = mapper.crearEntity(dto, entity, entityDenucio);
        repository.persist(documentoModificado);

        return mapper.crearDTO(documentoModificado);
    }
}
