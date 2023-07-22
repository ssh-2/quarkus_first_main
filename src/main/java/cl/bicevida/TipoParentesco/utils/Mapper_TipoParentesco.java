package cl.bicevida.TipoParentesco.utils;

import cl.bicevida.TipoParentesco.domain.DTO.Request_Save_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_TipoParentesco {

    public Response_DTO_TipoParentesco crearDTO(Entity_TipoParentesco entity){
        Response_DTO_TipoParentesco dto = new Response_DTO_TipoParentesco();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_TipoParentesco> crearDTO(List<Entity_TipoParentesco> entities){
        List<Response_DTO_TipoParentesco> dtos = new ArrayList<>();
        for(Entity_TipoParentesco entity : entities) {
          dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_TipoParentesco crearEntity(Request_Save_DTO_TipoParentesco dto){
        Entity_TipoParentesco entity = new Entity_TipoParentesco();
        entity.setNombre(dto.nombre);
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}
