package cl.bicevida.TipoCuentaBanco.utils;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Save_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_TipoCuentaBanco {
    public Response_DTO_TipoCuentaBanco crearDTO(Entity_TipoCuentaBanco entity){
        Response_DTO_TipoCuentaBanco dto = new Response_DTO_TipoCuentaBanco();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_TipoCuentaBanco> crearDTO(List<Entity_TipoCuentaBanco> entities){
        List<Response_DTO_TipoCuentaBanco> dtos = new ArrayList<>();
        for(Entity_TipoCuentaBanco entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_TipoCuentaBanco crearEntity(Request_Save_DTO_TipoCuentaBanco dto){
        Entity_TipoCuentaBanco entity = new Entity_TipoCuentaBanco();
        entity.setNombre(dto.nombre.trim());
        entity.setUsuarioCreacion(dto.getUsuarioCreacion().trim());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}
