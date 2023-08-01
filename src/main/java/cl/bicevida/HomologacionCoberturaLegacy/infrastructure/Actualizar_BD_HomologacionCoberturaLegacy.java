package cl.bicevida.HomologacionCoberturaLegacy.infrastructure;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Update_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.Entity_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.PuertoSalida_Actualizar_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.utils.Mapper_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import static cl.bicevida.Utils.Constants.NOT_FOUND_BY_ID;

@ApplicationScoped
@Slf4j
public class Actualizar_BD_HomologacionCoberturaLegacy implements PuertoSalida_Actualizar_HomologacionCoberturaLegacy {

    private final PanacheRepository_HomologacionCoberturaLegacy repository;

    private final Mapper_HomologacionCoberturaLegacy mapper;

    public Actualizar_BD_HomologacionCoberturaLegacy(PanacheRepository_HomologacionCoberturaLegacy repository, Mapper_HomologacionCoberturaLegacy mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Response_DTO_HomologacionCoberturaLegacy actualizar(Long id, Request_Update_DTO_HomologacionCoberturaLegacy dto) {
        Entity_HomologacionCoberturaLegacy entity = repository.findByIdOptional(id)
                .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
        entity.setRegistroCMF(dto.getRegistroCMF());
        entity.setFechaActualizacion(LocalDateTime.now());
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
