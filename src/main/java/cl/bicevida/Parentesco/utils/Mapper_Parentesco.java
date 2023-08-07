package cl.bicevida.Parentesco.utils;

import cl.bicevida.Parentesco.domain.DTO.Response_DTO_Parentesco;
import cl.bicevida.Parentesco.domain.modelo.Entity_Parentesco;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.utils.Mapper_Persona;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import cl.bicevida.TipoParentesco.utils.Mapper_TipoParentesco;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Slf4j
public class Mapper_Parentesco {


    private final Mapper_Persona mapperPersona;
    private final Mapper_TipoParentesco mapperTipoParentesco;

    public Mapper_Parentesco(Mapper_Persona mapperPersona, Mapper_TipoParentesco mapperTipoParentesco) {
        this.mapperPersona = mapperPersona;
        this.mapperTipoParentesco = mapperTipoParentesco;
    }

    public Response_DTO_Parentesco crearDTO(Entity_Parentesco entity) {

        Response_DTO_Persona persona = mapperPersona.crearDTO(entity.getPariente());
        Response_DTO_Persona pariente = mapperPersona.crearDTO(entity.getParienteRelacion());
        Response_DTO_TipoParentesco tipoParentesco = mapperTipoParentesco.crearDTO(entity.getTipoParentesco());

        Response_DTO_Parentesco dto = new Response_DTO_Parentesco();
        dto.setId(entity.getId());
        dto.setComentario(entity.getComentario());
        dto.setParticipacion(entity.getParticipacion());
        dto.setVigente(entity.getVigente());
        dto.setPariente(persona);
        dto.setPariente(pariente);
        dto.setTipoParentesco(tipoParentesco);

        return dto;
    }

    public List<Response_DTO_Parentesco> crearDTO(List<Entity_Parentesco> entities) {
        List<Response_DTO_Parentesco> dtos = new ArrayList<>();
        for (Entity_Parentesco entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }


    public Entity_Parentesco crearEntity(Entity_Persona persona,
                                         Entity_Persona pariente,
                                         Entity_TipoParentesco tipoParentesco,
                                         Boolean vigente,
                                         Double participacion,
                                         String comentario,
                                         String usuario
    ) {
        Entity_Parentesco entity = new Entity_Parentesco();

        Entity_Parentesco actualizado = generarEntity(
                entity,
                persona,
                pariente,
                tipoParentesco,
                vigente,
                participacion,
                comentario

        );
        actualizado.setUsuarioCreacion(usuario);
        actualizado.setFechaCreacion(LocalDateTime.now());
        return actualizado;
    }


    public Entity_Parentesco crearEntity(Entity_Parentesco entity,
                                         Entity_Persona persona,
                                         Entity_Persona pariente,
                                         Entity_TipoParentesco tipoParentesco,
                                         Boolean vigente,
                                         Double participacion,
                                         String comentario,
                                         String usuario
                                         ) {
        Entity_Parentesco actualizado = generarEntity(
                entity,
                persona,
                pariente,
                tipoParentesco,
                vigente,
                participacion,
                comentario

        );
        actualizado.setUsuarioActualizacion(usuario);
        actualizado.setFechaActualizacion(LocalDateTime.now());
        return actualizado;
    }

    private Entity_Parentesco generarEntity(
            Entity_Parentesco entity,
            Entity_Persona persona,
            Entity_Persona pariente,
            Entity_TipoParentesco tipoParentesco,
            Boolean vigente,
            Double participacionIn,
            String comentario
    ) {

        Double participacion = 0D;
        if (participacionIn != null) {
            participacion = participacionIn;
        }

        entity.setPariente(persona);
        entity.setParienteRelacion(pariente);
        entity.setTipoParentesco(tipoParentesco);
        entity.setVigente(vigente);
        entity.setParticipacion(participacion);
        entity.setComentario(comentario);

        return entity;
    }

}
