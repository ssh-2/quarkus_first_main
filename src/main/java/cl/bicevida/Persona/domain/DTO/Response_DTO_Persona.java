package cl.bicevida.Persona.domain.DTO;

import cl.bicevida.TipoPersona.domain.DTO.Response_DTO_TipoPersona;
import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response_DTO_Persona {

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Schema(required = true, implementation = String.class, example = "26000111")
    @JsonbProperty("rut")
    public String rut;

    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty("dv")
    public String dv;

    @Schema(required = true, implementation = String.class, example = "Jhon")
    @JsonbProperty("nombresRazonSocial")
    public String nombresRazonSocial;

    @Schema(required = true, implementation = String.class, example = "Doe")
    @JsonbProperty("apellido1")
    public String apellido1;

    @Schema(required = true, implementation = String.class, example = "Polanzki")
    @JsonbProperty("apellido2")
    public String apellido2;

    @Schema(required = true, implementation = String.class, example = "masculino")
    @JsonbProperty("sexo")
    public String sexo;

    @Schema(required = true, implementation = String.class, example = "elmakina@gmail.com")
    @JsonbProperty("email")
    public String email;

    @Schema(required = true, implementation = Entity_TipoPersona.class, example = "{id:1, nombre:'Natural'}")
    @JsonbProperty("tipo_persona")
    private Response_DTO_TipoPersona tipo_persona;

    @Schema(required = true, implementation = LocalDateTime.class, example = "31-12-2022")
    @JsonbProperty("fechaNacimiento")
    public LocalDate fechaNacimiento;

    @Schema(required = false, implementation = String.class, example = "1")
    @JsonbProperty("idPersonaLegacy")
    private String idPersonaLegacy;

}


