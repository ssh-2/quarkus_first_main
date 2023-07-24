package cl.bicevida.Persona.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Request_Save_DTO_Persona {



    @NotNull(message=rutJson + ES_REQUERIDO)
    @Size(min = rutMin,max = rutMax,message = rutSize)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = rutJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = String.class, example = "26000111")
    @JsonbProperty(rutJson)
    public String rut;

    @NotNull(message=dvJson + ES_REQUERIDO)
    @Size(max = dvMax,message = dvSize)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS_K,message = dvJson + ERROR_FORMATO_SOLO_NUMEROS_K)
    @Schema(required = true, implementation = String.class, example = "K")
    @JsonbProperty(dvJson)
    public String dv;

    @NotNull(message= nombresRazonSocialJson + ES_REQUERIDO)
    @Size(min = nombresRazonSocialMin,max = nombresRazonSocialMax,message = nombresRazonSocialSize)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO,message = nombresRazonSocialJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty(nombresRazonSocialJson)
    public String nombresRazonSocial;

    @NotNull(message= apellido1Json + ES_REQUERIDO)
    @Size(min = apellido1Min,max = apellido1Max,message = apellido1Size)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO,message = apellido1Json + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Doe")
    @JsonbProperty(apellido1Json)
    public String apellido1;

    @NotNull(message= apellido2Json + ES_REQUERIDO)
    @Size(min = apellido2Min,max = apellido2Max,message = apellido2Size)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO,message = apellido2Json + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Polanzki")
    @JsonbProperty(apellido2Json)
    public String apellido2;

    @NotNull(message= sexoJson + ES_REQUERIDO)
    @Size(min = sexoMin,max = sexoMax,message = sexoSize)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO,message = sexoJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "masculino")
    @JsonbProperty(sexoJson)
    public String sexo;


    @NotNull(message= usuarioCreacionJson + ES_REQUERIDO)
    @Size(min = usuarioCreacionMin,max = usuarioCreacionMax,message = usuarioCreacionSize)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO,message = usuarioCreacionJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty(usuarioCreacionJson)
    private String usuarioCreacion;

    @NotNull(message= emailJson + ES_REQUERIDO)
    @Size(min = emailMin,max = emailMax,message = emailSize)
    @Pattern(regexp  = REGEX_EMAIL,message = emailJson + ERROR_FORMATO_EMAIL)
    @Schema(required = true, implementation = String.class, example = "elmakina@gmail.com")
    @JsonbProperty(emailJson)
    public String email;

    @NotNull(message= fechaNacimientoJson + ES_REQUERIDO)
    @Pattern(regexp  = REGEX_FECHA_YEAR_MES_DIA,message = fechaNacimientoJson + ERROR_FORMATO_FECHA)
    @Schema(required = true, implementation = String.class, example = "2022-01-31")
    @JsonbProperty(fechaNacimientoJson)
    @JsonFormat(pattern = "yyyy-MM-dd")
    public String fechaNacimiento;

    @NotNull(message= tipo_personaJson + ES_REQUERIDO)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = tipo_personaJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty(tipo_personaJson)
    private String id_tipo_persona;


    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = tipo_personaJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = false, implementation = Long.class, example = "1")
    @JsonbProperty(idPersonaLegacyJson)
    private String idPersonaLegacy;
}
