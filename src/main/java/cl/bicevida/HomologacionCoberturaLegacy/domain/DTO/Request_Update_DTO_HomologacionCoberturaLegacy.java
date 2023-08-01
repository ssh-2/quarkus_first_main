package cl.bicevida.HomologacionCoberturaLegacy.domain.DTO;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static cl.bicevida.Utils.Constants.*;

@Getter
@Setter
@NoArgsConstructor
public class Request_Update_DTO_HomologacionCoberturaLegacy {

    private final int minUsuario = 3;
    private final int maxUsuario = 250;
    private final String sizeUsuario = "[usuarioActualizacion]" + DEBE_POSEER_MINIMO + minUsuario + DEBE_POSEER_MAXIMO + maxUsuario;

    @NotNull(message = "El campo 'registro_cmf' es requerido")
    @Size(max = 50, message = "El campo 'registro_cmf' no debe superar los 50 caracteres")
    @Schema(required = true, implementation = String.class, example = "Registro CMF")
    @JsonbProperty("registroCmf")
    public String registroCMF;

    @NotNull(message="[usuarioActualizacion]" + ES_REQUERIDO)
    @Size(min = minUsuario,max = maxUsuario,message = sizeUsuario)
    @Schema(required = true, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;
}
