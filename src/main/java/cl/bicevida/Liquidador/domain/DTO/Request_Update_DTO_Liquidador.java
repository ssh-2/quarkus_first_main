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
public class Request_Update_DTO_Liquidador {

    private final int minNombre = 3;
    private final int maxNombre = 250;
    private final String sizeNombre = "[nombre]" + DEBE_POSEER_MINIMO + minNombre + DEBE_POSEER_MAXIMO + maxNombre;

    private final int minUsuario = 3;
    private final int maxUsuario = 250;
    private final String sizeUsuario = "[usuarioActualizacion]" + DEBE_POSEER_MINIMO + minUsuario + DEBE_POSEER_MAXIMO + maxUsuario;


    @NotNull(message="[nombre]" + ES_REQUERIDO)
    @Size(min = minNombre,max = maxNombre,message = sizeNombre)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_TRIM,message = "[nombre]" + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Natural")
    @JsonbProperty("nombre")
    public String nombre;

    @NotNull(message="[usuarioActualizacion]" + ES_REQUERIDO)
    @Size(min = minUsuario,max = maxUsuario,message = sizeUsuario)
    @Schema(required = true, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;

    @NotNull(message= emailJson + ES_REQUERIDO)
    @Size(min = emailMin,max = emailMax,message = emailSize)
    @Pattern(regexp  = REGEX_EMAIL,message = emailJson + ERROR_FORMATO_EMAIL)
    @Schema(required = true, implementation = String.class, example = "elmakina@gmail.com")
    @JsonbProperty(emailJson)
    public String email;
}
