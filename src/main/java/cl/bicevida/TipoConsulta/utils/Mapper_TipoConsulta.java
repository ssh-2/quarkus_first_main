package cl.bicevida.TipoConsulta.utils;

import cl.bicevida.TipoConsulta.domain.DTO.Request_Save_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.DTO.Response_DTO_TipoConsulta;
import cl.bicevida.TipoConsulta.domain.modelo.Entity_TipoConsulta;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_TipoConsulta {

    public Response_DTO_TipoConsulta crearDTO(Entity_TipoConsulta entity){
        Response_DTO_TipoConsulta dto = new Response_DTO_TipoConsulta();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_TipoConsulta> crearDTO(List<Entity_TipoConsulta> entities){
        List<Response_DTO_TipoConsulta> dtos = new ArrayList<>();
        for(Entity_TipoConsulta entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_TipoConsulta crearEntity(Request_Save_DTO_TipoConsulta dto){
        Entity_TipoConsulta entity = new Entity_TipoConsulta();
        entity.setNombre(dto.nombre.trim());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion().trim());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }
}
