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

import static cl.bicevida.Utils.Constants.*;

@Getter
@Setter
@NoArgsConstructor
public class Request_Update_DTO_Persona {

    private final int minUsuario = 3;
    private final int maxUsuario = 250;
    private final String sizeUsuario = "[usuarioActualizacion]" + DEBE_POSEER_MINIMO + minUsuario + DEBE_POSEER_MAXIMO + maxUsuario;

    private final String rutJson = "rut";
    private final int rutMin = 6;
    private final int rutMax = 8;
    private final String rutSize = rutJson + DEBE_POSEER_MINIMO + rutMin + DEBE_POSEER_MAXIMO + rutMax;

    private final String dvJson = "dv";
    private final int dvMax = 1;
    private final String dvSize = dvJson + " requiere solo: " + dvMax + " caracter; desde el 0 al 9 o la K mayúscula, sin el guion";

    private final String nombresRazonSocialJson = "nombresRazonSocial";
    private final int nombresRazonSocialMin = 2;
    private final int nombresRazonSocialMax = 250;
    private final String nombresRazonSocialSize = nombresRazonSocialJson + DEBE_POSEER_MINIMO + nombresRazonSocialMin + DEBE_POSEER_MAXIMO + nombresRazonSocialMax;

    private final String apellido1Json = "apellido1";
    private final int apellido1Min = 2;
    private final int apellido1Max = 250;
    private final String apellido1Size = apellido1Json + DEBE_POSEER_MINIMO + apellido1Min + DEBE_POSEER_MAXIMO + apellido1Max;

    private final String apellido2Json = "apellido2";
    private final int apellido2Min = 2;
    private final int apellido2Max = 250;
    private final String apellido2Size = apellido2Json + DEBE_POSEER_MINIMO + apellido2Min + DEBE_POSEER_MAXIMO + apellido2Max;

    private final String sexoJson = "sexo";
    private final int sexoMin = 3;
    private final int sexoMax = 250;
    private final String sexoSize = sexoJson + DEBE_POSEER_MINIMO + sexoMin + DEBE_POSEER_MAXIMO + sexoMax;

    private final String emailJson = "email";
    private final int emailMin = 5;
    private final int emailMax = 250;
    private final String emailSize = emailJson + DEBE_POSEER_MINIMO + emailMin + DEBE_POSEER_MAXIMO + emailMax;

    private final String tipo_personaJson = "idTipoPersona";
    private final int tipo_personaMin = 1;
    private final int tipo_personaMax = 2;
    private final String tipo_personaSize = tipo_personaJson + DEBE_POSEER_MINIMO + tipo_personaMin + DEBE_POSEER_MAXIMO + tipo_personaMax;

    private final String usuarioJson = "usuarioActualizacion";
    private final int usuarioMin = 1;
    private final int usuarioMax = 250;
    private final String usuarioSize = usuarioJson + DEBE_POSEER_MINIMO + usuarioMin + DEBE_POSEER_MAXIMO + usuarioMax;


    private final String fechaNacimientoJson = "fechaNacimiento";
    private final int fechaNacimientoMin = 1;
    private final int fechaNacimientoMax = 10;
    private final String fechaNacimientoSize = fechaNacimientoJson + DEBE_POSEER_MINIMO + fechaNacimientoMin + DEBE_POSEER_MAXIMO + fechaNacimientoMax;

    private final String idPersonaLegacyJson = "idPersonaLegacy";

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

    @NotNull(message= tipo_personaJson + ES_REQUERIDO)
    @Size(min = tipo_personaMin,max = tipo_personaMax,message = tipo_personaSize)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = tipo_personaJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty(tipo_personaJson)
    private String id_tipo_persona;

    @NotNull(message= usuarioJson + ES_REQUERIDO)
    @Size(min = usuarioMin,max = usuarioMax,message = usuarioSize)
    @Pattern(regexp  = REGEX_SOLO_LETRAS_SIN_ESPACIO_AL_COMIENZO,message = usuarioJson + ERROR_FORMATO_SOLO_LETRAS)
    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty(usuarioJson)
    private String usuarioActualizacion;

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

    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = tipo_personaJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty(idPersonaLegacyJson)
    private String idPersonaLegacy;
}
