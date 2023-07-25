package cl.bicevida.Liquidador.domain.DTO;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static cl.bicevida.Persona.utils.Persona_Constants.*;
import static cl.bicevida.Utils.Constants.*;

@Getter
@Setter
@NoArgsConstructor
public class Request_Save_DTO_Liquidador {

    private final String nombreJson = "nombre";
    private final int minNombre = 3;
    private final int maxNombre = 250;
    private final String sizeNombre = nombreJson + DEBE_POSEER_MINIMO + minNombre + DEBE_POSEER_MAXIMO + maxNombre;

    private final String usuarioJson = "usuarioCreacion";
    private final int minUsuario = 3;
    private final int maxUsuario = 250;
    private final String sizeUsuario = usuarioJson + DEBE_POSEER_MINIMO + minUsuario + DEBE_POSEER_MAXIMO + maxUsuario;


    @NotNull(message=nombreJson + ES_REQUERIDO)
    @Size(min = minNombre,max = maxNombre,message = sizeNombre)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_TRIM,message = nombreJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Natural")
    @JsonbProperty(nombreJson)
    public String nombre;

    @NotNull(message=usuarioJson + ES_REQUERIDO)
    @Size(min = minUsuario,max = maxUsuario,message = sizeUsuario)
    @Schema(required = true, implementation = String.class, example = "user123")
    @JsonbProperty(usuarioJson)
    private String usuarioCreacion;

    @NotNull(message= emailJson + ES_REQUERIDO)
    @Size(min = emailMin,max = emailMax,message = emailSize)
    @Pattern(regexp  = REGEX_EMAIL,message = emailJson + ERROR_FORMATO_EMAIL)
    @Schema(required = true, implementation = String.class, example = "elmakina@gmail.com")
    @JsonbProperty(emailJson)
    public String email;
}
