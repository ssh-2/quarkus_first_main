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
import static cl.bicevida.Utils.Constants.*;


@Getter
@Setter
@NoArgsConstructor
public class Request_Save_DTO_Documento {

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

    @NotNull(message = usuarioCreacionJson + ES_REQUERIDO)
    @Size(min = usuarioCreacionMin,max = usuarioCreacionMax,message = usuarioCreacionSize)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_TRIM,message = usuarioCreacionJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty(usuarioCreacionJson)
    private String usuarioCreacion;

}
