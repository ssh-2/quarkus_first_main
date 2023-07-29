package cl.bicevida.Canal.utils;

import cl.bicevida.Canal.domain.DTO.Request_Save_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Response_DTO_Canal;
import cl.bicevida.Canal.domain.modelo.Entity_Canal;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_Canal {
    public Response_DTO_Canal crearDTO(Entity_Canal entity){
        Response_DTO_Canal dto = new Response_DTO_Canal();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_Canal> crearDTO(List<Entity_Canal> entities){
        List<Response_DTO_Canal> dtos = new ArrayList<>();
        for(Entity_Canal entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_Canal crearEntity(Request_Save_DTO_Canal dto){
        Entity_Canal entity = new Entity_Canal();
        entity.setNombre(dto.nombre);
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}
