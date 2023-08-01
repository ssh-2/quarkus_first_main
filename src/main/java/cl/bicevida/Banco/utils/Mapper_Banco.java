package cl.bicevida.Banco.utils;

import cl.bicevida.Banco.domain.DTO.Request_Save_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Response_DTO_Banco;
import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_Banco {

    public Response_DTO_Banco crearDTO(Entity_Banco entity){
        Response_DTO_Banco dto = new Response_DTO_Banco();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_Banco> crearDTO(List<Entity_Banco> entities){
        List<Response_DTO_Banco> dtos = new ArrayList<>();
        for(Entity_Banco entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_Banco crearEntity(Request_Save_DTO_Banco dto){
        Entity_Banco entity = new Entity_Banco();
        entity.setNombre(dto.nombre);
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}
