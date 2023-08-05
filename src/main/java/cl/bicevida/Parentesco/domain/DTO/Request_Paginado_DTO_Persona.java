package cl.bicevida.Parentesco.domain.DTO;

import cl.bicevida.Utils.PaginadoRequest;
import jakarta.json.bind.annotation.JsonbProperty;
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
public class Request_Paginado_DTO_Persona {

    @Size(min = rutMin, max = rutMax ,message = rutSize)
    @Pattern(regexp  = REGEX_LETRAS_Y_NUMEROS_Y_GUION,message = rutSize + ERROR_SOLO_LETRAS_NUMEROS_GUION)
    @Schema(required = true, implementation = String.class, example = "26000111")
    @JsonbProperty(rutJson)
    private String rut;

    @Size(max = dvMax ,message = dvSize)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS_K,message = dvJson + ERROR_FORMATO_SOLO_NUMEROS_K)
    @Schema(required = true, implementation = String.class, example = "K, si es esRutChileno no debe enviarse el parametro")
    @JsonbProperty(dvJson)
    private String dv;

    @Size(min = nombresRazonSocialMin, max = nombresRazonSocialMax ,message = nombresRazonSocialSize)
    @Pattern(regexp  = REGEX_LETRAS_Y_NUMEROS_Y_GUION,message = nombresRazonSocialJson + ERROR_SOLO_LETRAS_NUMEROS_GUION)
    @Schema(required = true, implementation = String.class, example = "Jhon Doe")
    @JsonbProperty(nombresRazonSocialJson)
    private String nombreRazonSocial;

    @Size(min = idPersonaLegacyJsonMin, max = idPersonaLegacyJsonMax ,message = idPersonaLegacyJsonSizeMsg)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = idPersonaLegacyJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty(idPersonaLegacyJson)
    private String idPersonaLegacy;


    private PaginadoRequest paginado;

}
