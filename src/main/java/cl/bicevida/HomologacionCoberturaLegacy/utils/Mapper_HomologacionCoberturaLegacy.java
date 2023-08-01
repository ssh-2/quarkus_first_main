package cl.bicevida.HomologacionCoberturaLegacy.utils;

import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Save_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Response_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.Entity_HomologacionCoberturaLegacy;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_HomologacionCoberturaLegacy {

    public Response_DTO_HomologacionCoberturaLegacy crearDTO(Entity_HomologacionCoberturaLegacy entity) {
        Response_DTO_HomologacionCoberturaLegacy dto = new Response_DTO_HomologacionCoberturaLegacy();
        dto.setId(entity.getId());
        dto.setIdCoberturaLegacy(entity.getIdCoberturaLegacy());
        dto.setIdLineaNegocioLegacy(entity.getIdLineaNegocioLegacy());
        dto.setRegistroCMF(entity.getRegistroCMF());
        return dto;
    }

    public List<Response_DTO_HomologacionCoberturaLegacy> crearDTO(List<Entity_HomologacionCoberturaLegacy> modelos) {
        List<Response_DTO_HomologacionCoberturaLegacy> dtos = new ArrayList<>();
        for (Entity_HomologacionCoberturaLegacy entity : modelos) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_HomologacionCoberturaLegacy creatEntity(Request_Save_DTO_HomologacionCoberturaLegacy dto) {
        Entity_HomologacionCoberturaLegacy entity = new Entity_HomologacionCoberturaLegacy();
        entity.setRegistroCMF(dto.getRegistroCMF().trim());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion().trim());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }
}
