package cl.bicevida.TipoDenuncio.utils;

import cl.bicevida.TipoDenuncio.domain.DTO.Request_Save_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Response_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Mapper_TipoDenucio {
    public Response_DTO_TipoDenucio crearDTO(Entity_TipoDenucio entity){
        Response_DTO_TipoDenucio dto = new Response_DTO_TipoDenucio();
        dto.setId(entity.getId());
        dto.setNombre(entity.nombre);
        return dto;
    }

    public List<Response_DTO_TipoDenucio> crearDTO(List<Entity_TipoDenucio> entities){
        List<Response_DTO_TipoDenucio> dtos = new ArrayList<>();
        for(Entity_TipoDenucio entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_TipoDenucio crearEntity(Request_Save_DTO_TipoDenucio dto){
        Entity_TipoDenucio entity = new Entity_TipoDenucio();
        entity.setNombre(dto.nombre);
        entity.setUsuarioCreacion(dto.getUsuarioCreacion());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

}

