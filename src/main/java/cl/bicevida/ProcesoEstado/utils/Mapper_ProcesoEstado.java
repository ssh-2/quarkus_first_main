package cl.bicevida.ProcesoEstado.utils;

import cl.bicevida.ProcesoEstado.domain.DTO.Request_Save_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.DTO.Response_DTO_ProcesoEstado;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_ProcesoEstado {
    public Response_DTO_ProcesoEstado crearDTO(Entity_ProcesoEstado entity){
        Response_DTO_ProcesoEstado dto = new Response_DTO_ProcesoEstado();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_ProcesoEstado> crearDTO(List<Entity_ProcesoEstado> entities){
        List<Response_DTO_ProcesoEstado> dtos = new ArrayList<>();
        for(Entity_ProcesoEstado entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_ProcesoEstado crearEntity(Request_Save_DTO_ProcesoEstado dto){
        Entity_ProcesoEstado entity = new Entity_ProcesoEstado();
        entity.setNombre(dto.nombre);
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}
