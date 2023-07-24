package cl.bicevida.TipoPersona.utils;

import cl.bicevida.TipoPersona.domain.DTO.Request_Save_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_TipoPersona {

    public Response_DTO_TipoPersona crearDTO(Entity_TipoPersona entity){
        Response_DTO_TipoPersona dto = new Response_DTO_TipoPersona();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_TipoPersona> crearDTO(List<Entity_TipoPersona> entities){
        List<Response_DTO_TipoPersona> dtos = new ArrayList<>();
        for(Entity_TipoPersona entity : entities) {
          dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_TipoPersona crearEntity(Request_Save_DTO_TipoPersona dto){
        Entity_TipoPersona entity = new Entity_TipoPersona();
        entity.setNombre(dto.nombre.trim());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion().trim());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}
