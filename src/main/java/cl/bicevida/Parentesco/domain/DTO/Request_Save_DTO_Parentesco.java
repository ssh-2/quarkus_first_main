package cl.bicevida.Parentesco.domain.DTO;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static cl.bicevida.Parentesco.utils.Constants_Parentesco.*;
import static cl.bicevida.Utils.Constants.REGEX_SOLO_NUMEROS;

@Getter
@Setter
@NoArgsConstructor
public class Request_Save_DTO_Parentesco {

    @NotNull(message = idParienteParentescoJson_MSG_REQUIRED)
    @Size(min = idParienteParentescoJson_MIN, max = idParienteParentescoJson_MAX, message = idParienteParentescoJson_MSG_SIZE)
    @Pattern(regexp = REGEX_SOLO_NUMEROS, message = idParienteParentescoJson_MSG_PATTERN)
    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty(idParienteParentescoJson)
    public String idPersona;

    @NotNull(message = idParienteRelacionParentescoJsonMSG_REQUIRED)
    @Size(min = idParienteRelacionParentescoJson_MIN, max = idParienteRelacionParentescoJson_MAX, message = idParienteRelacionParentescoJsonMSG_SIZE)
    @Pattern(regexp = REGEX_SOLO_NUMEROS, message = idParienteRelacionParentescoJsonMSG_PATTERN)
    @Schema(required = true, implementation = String.class, example = "2")
    @JsonbProperty(idParienteRelacionParentescoJson)
    public String idPariente;


    @NotNull(message = idTipoParentescoParentescoJsonMSG_REQUIRED)
    @Size(min = idTipoParentescoParentescoJson_MIN, max = idTipoParentescoParentescoJson_MAX, message = idTipoParentescoParentescoJsonMSG_SIZE)
    @Pattern(regexp = REGEX_SOLO_NUMEROS, message = idTipoParentescoParentescoJsonMSG_PATTERN)
    @Schema(required = true, implementation = String.class, example = "3")
    @JsonbProperty(idTipoParentescoParentescoJson)
    public String idTipoParentesco;


    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty(vigenteParentescoJson)
    public Boolean vigente;

    @Size(min = participacionParentescoJson_MIN, max = participacionParentescoJson_MAX, message = participacionParentescoJsonMSG_SIZE)
    @Pattern(regexp = REGEX_SOLO_NUMEROS, message = participacionParentescoJsonMSG_PATTERN)
    @Schema(required = true, implementation = String.class, example = "80")
    @JsonbProperty(participacionParentescoJson)
    public String participacion;


    @Size(min = comentarioParentescoJson_MIN, max = comentarioParentescoJson_MAX, message = comentarioParentescoJsonMSG_SIZE)
    @Schema(required = true, implementation = String.class, example = "Algun comentario incluye numeros 1232 .,#$")
    @JsonbProperty(comentarioParentescoJson)
    public String comentario;

    @NotNull(message = usuarioCreacionParentescoJsonMSG_REQUIRED)
    @Size(min = usuarioCreacionParentescoMin, max = usuarioCreacionParentescoMax, message = usuarioCreacionParentescoSize)
    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty(usuarioCreacionParentescoJson)
    private String usuarioCreacion;

}
