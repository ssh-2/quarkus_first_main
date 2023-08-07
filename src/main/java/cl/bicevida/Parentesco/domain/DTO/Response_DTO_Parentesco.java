package cl.bicevida.Parentesco.domain.DTO;

import cl.bicevida.Persona.domain.DTO.Response_DTO_Persona;
import cl.bicevida.TipoParentesco.domain.DTO.Response_DTO_TipoParentesco;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonbPropertyOrder(value =  {"id","pariente", "pariente","tipoParentesco","vigente","participacion","comentario"})
public class Response_DTO_Parentesco {

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty("persona")
    public Response_DTO_Persona pariente;

    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty("pariente")
    public Response_DTO_Persona parienteRelacion;

    @Schema(required = true, implementation = String.class, example = "{'i'd:'1','descripcion':'algo'}")
    @JsonbProperty("tipoParentesco")
    public Response_DTO_TipoParentesco tipoParentesco;

    @Schema(required = true, implementation = String.class, example = "true")
    @JsonbProperty("vigente")
    public Boolean vigente;

    @Schema(required = true, implementation = Double.class, example = "80")
    @JsonbProperty("participacion")
    public Double participacion;

    @Schema(required = true, implementation = String.class, example = "Test de comentario")
    @JsonbProperty("comentario")
    public String comentario;

}


