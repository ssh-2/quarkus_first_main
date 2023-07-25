package cl.bicevida.Liquidador.utils;

import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_Liquidador {

    public Response_DTO_Liquidador crearDTO(Entity_Liquidador entity){
        Response_DTO_Liquidador dto = new Response_DTO_Liquidador();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        dto.setEmail(entity.email);
        return dto;
    }

    public List<Response_DTO_Liquidador> crearDTO(List<Entity_Liquidador> entities){
        List<Response_DTO_Liquidador> dtos = new ArrayList<>();
        for(Entity_Liquidador entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_Liquidador crearEntity(Request_Save_DTO_Liquidador dto){
        Entity_Liquidador entity = new Entity_Liquidador();
        entity.setNombre(dto.nombre.trim());
        entity.setEmail(dto.email.trim());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion().trim());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }


}
