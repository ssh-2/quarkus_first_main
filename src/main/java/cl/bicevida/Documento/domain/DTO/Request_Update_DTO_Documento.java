package cl.bicevida.Documento.domain.DTO;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static cl.bicevida.Documento.utils.Documento_Constants.*;
import static cl.bicevida.Documento.utils.Documento_Constants.usuarioCreacionJson;
import static cl.bicevida.Utils.Constants.*;
import static cl.bicevida.Utils.Constants.ERROR_FORMATO_SOLO_LETRAS;

@Getter
@Setter
@NoArgsConstructor
public class Request_Update_DTO_Documento {
    @NotNull(message = "denucio" + ES_REQUERIDO)
    @JsonbProperty("denuncio")
    public Entity_Denucio denuncio;

    @NotNull(message = descripcionJson + ES_REQUERIDO)
    @Size(min = minLongitudDescripcion, max = maxLongitudDescripcion, message = descripcionSize)
    @Column(name = "descripcion", nullable = true)
    @Schema(required = false, implementation = String.class)
    @JsonbProperty("descripcion")
    public String descripcion;

    @NotNull(message = pathJson + ES_REQUERIDO)
    @Size(min = minLongitudPath, max = maxLongitudPath, message = pathSize)
    @Column(name = "path", nullable = true)
    @Pattern(regexp =  REGEX_SOLO_LETRAS_TRIM, message = pathJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = false, implementation = String.class)
    @JsonbProperty("path")
    public String path;

    @NotNull(message= usuarioActualizacionJson + ES_REQUERIDO)
    @Size(min = usuarioActualizacionJsonMin,max = usuarioActualizacionJsonMax,message = usuarioActualizacionJsonMsg)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_TRIM,message = usuarioActualizacionJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty(usuarioActualizacionJson)
    private String usuarioActualizacion;

}
