package cl.bicevida.Documento.utils;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import cl.bicevida.Documento.domain.DTO.Request_Save_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Request_Update_DTO_Documento;
import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.modelo.Entity_Documento;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
@Slf4j
public class Mapper_Documento {

    public Response_DTO_Documento crearDTO(Entity_Documento entity) {
        Response_DTO_Documento dto = new Response_DTO_Documento();
        dto.setDenuncio(entity.getDenuncio());
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPath(entity.getPath());

        return dto;
    }

    public List<Response_DTO_Documento> crearDTO(List<Entity_Documento> entities) {
        List<Response_DTO_Documento> dtos = new ArrayList<>();
        for (Entity_Documento entity  : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    public Entity_Documento crearEntity(Request_Save_DTO_Documento dto, Entity_Denucio denucio) {
        Entity_Documento entity = new Entity_Documento();
        Entity_Documento actualizado = generarEntity(entity,
        denucio,
        getDescripcion(dto),
        getPath(dto)
        );
        actualizado.setUsuarioCreacion(dto.getUsuarioCreacion());
        actualizado.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

    public Entity_Documento crearEntity(Request_Update_DTO_Documento dto, Entity_Documento entity, Entity_Denucio denucio) {
        Entity_Documento actualizado = generarEntity(entity,
                denucio,
                getDescripcion(dto),
                getPath(dto)
                );
        actualizado.setUsuarioActualizacion(dto.getUsuarioActualizacion());
        actualizado.setFechaActualizacion(LocalDateTime.now());
        return actualizado;
    }

    private Entity_Documento generarEntity(Entity_Documento entity,
                          Entity_Denucio denucio,
                          String descripcion,
                          String path
                          ){
        entity.setDenuncio(denucio);
        entity.setDescripcion(descripcion);
        entity.setPath(path);
        return entity;
    }

    protected String getDescripcion(Request_Save_DTO_Documento dto) {
        if(dto.getDescripcion()==null) {
            return null;
        }
        return dto.getDescripcion();
    }
    protected String getDescripcion(Request_Update_DTO_Documento dto) {
        if(dto.getDescripcion()==null) {
            return null;
        }
        return dto.getDescripcion();
    }
    protected String getPath(Request_Save_DTO_Documento dto) {
        if(dto.getPath()==null) {
            return null;
        }
        return dto.getPath();
    }
    protected String getPath(Request_Update_DTO_Documento dto) {
        if(dto.getPath()==null) {
            return null;
        }
        return dto.getPath();
    }
}
