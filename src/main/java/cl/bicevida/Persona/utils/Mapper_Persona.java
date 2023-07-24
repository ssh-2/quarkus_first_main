package cl.bicevida.Persona.utils;

import cl.bicevida.Persona.domain.DTO.Request_Save_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Request_Update_DTO_Persona;
import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Slf4j
public class Mapper_Persona {


    public Response_DTO_Persona crearDTO(Entity_Persona entity) {
        Response_DTO_TipoPersona tipoPersona = new Response_DTO_TipoPersona();
        tipoPersona.setNombre(entity.getTipo_persona().getNombre());
        tipoPersona.setId(entity.getTipo_persona().getId());

        Response_DTO_Persona dto = new Response_DTO_Persona();
        dto.setId(entity.getId());
        dto.setRut(entity.getRut());
        dto.setDv(entity.getDv());
        dto.setNombresRazonSocial(entity.getNombresRazonSocial());
        dto.setApellido1(entity.getApellido1());
        dto.setApellido2(entity.getApellido2());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setSexo(entity.getSexo());
        dto.setEmail(entity.getEmail());
        dto.setTipo_persona(tipoPersona);
        dto.setIdPersonaLegacy(entity.getIdPersonaLegacy());
        return dto;
    }

    public List<Response_DTO_Persona> crearDTO(List<Entity_Persona> entities) {
        List<Response_DTO_Persona> dtos = new ArrayList<>();
        for (Entity_Persona entity : entities) {
            dtos.add(crearDTO(entity));
        }
        return dtos;
    }

    @SneakyThrows
    public Entity_Persona crearEntity(Request_Save_DTO_Persona dto, Entity_TipoPersona tipoPersona) {
        Entity_Persona entity = new Entity_Persona();
        Entity_Persona actualizado = generarEntity(entity,
                dto.getRut(),
                dto.getDv(),
                dto.getNombresRazonSocial(),
                dto.getApellido1(),
                dto.getApellido2(),
                dto.getFechaNacimiento(),
                dto.getSexo(),
                dto.getEmail(),
                tipoPersona,
                dto.getIdPersonaLegacy()
        );
        actualizado.setUsuarioActualizacion(dto.getUsuarioCreacion());
        actualizado.setFechaActualizacion(LocalDateTime.now());
        return entity;
    }

    public Entity_Persona crearEntity(Request_Update_DTO_Persona dto, Entity_TipoPersona tipoPersona, Entity_Persona entity) {
        Entity_Persona actualizado = generarEntity(entity,
                dto.getRut(),
                dto.getDv(),
                dto.getNombresRazonSocial(),
                dto.getApellido1(),
                dto.getApellido2(),
                dto.getFechaNacimiento(),
                dto.getSexo(),
                dto.getEmail(),
                tipoPersona,
                dto.getIdPersonaLegacy()
                );
        actualizado.setUsuarioActualizacion(dto.getUsuarioActualizacion());
        actualizado.setFechaActualizacion(LocalDateTime.now());
        return actualizado;
    }

    private Entity_Persona generarEntity(Entity_Persona entity,
                                         String rut,
                                         String dv,
                                         String nombre,
                                         String apellido1,
                                         String apellido2,
                                         String fechaNacimientoString,
                                         String sexo,
                                         String email,
                                         Entity_TipoPersona tipoPersona,
                                         String IdPersonaLegacy
    ){
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString);
        entity.setRut(rut.trim());
        entity.setDv(dv.trim());
        entity.setNombresRazonSocial(nombre.trim());
        entity.setApellido1(apellido1.trim());
        entity.setApellido2(apellido2.trim());
        entity.setFechaNacimiento(fechaNacimiento);
        entity.setSexo(sexo.trim());
        entity.setEmail(email.trim());
        entity.setTipo_persona(tipoPersona);
        entity.setIdPersonaLegacy(IdPersonaLegacy.trim());
        return entity;
    }
}
