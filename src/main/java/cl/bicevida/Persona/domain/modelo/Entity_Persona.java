package cl.bicevida.Persona.domain.modelo;

import cl.bicevida.TipoPersona.domain.modelo.Entity_TipoPersona;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "persona")
@Schema(
        description = "(Descripción del esquema de datos) payload Persona",
        name = "Persona (nombre del esquema)"
)
public class Entity_Persona  {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "rut")
    @Schema(required = false, implementation = String.class, example = "1")
    @JsonbProperty("rut")
    public String rut;

    @Column(name = "dv")
    @Schema(required = true, implementation = String.class, example = "9")
    @JsonbProperty("dv")
    public String dv;

    @Column(name = "nombres_Razon_Social")
    @Schema(required = true, implementation = String.class, example = "Juan Carlos")
    @JsonbProperty("nombresRazonSocial")
    public String nombresRazonSocial;

    @Column(name = "apellido_1")
    @Schema(required = true, implementation = String.class, example = "Pérez")
    @JsonbProperty("apellido1")
    public String apellido1;

    @Column(name = "apellido_2")
    @Schema(required = true, implementation = String.class, example = "Gómez")
    @JsonbProperty("apellido2")
    public String apellido2;

    @Column(name = "fecha_Nacimiento")
    @Schema(required = true, implementation = LocalDateTime.class, example = "1990-01-01")
    @JsonbProperty("fechaNacimiento")
    public LocalDate fechaNacimiento;

    @Column(name = "sexo")
    @Schema(required = true, implementation = String.class, example = "Masculino")
    @JsonbProperty("sexo")
    public String sexo;

    @Column(name = "email")
    @Schema(required = true, implementation = String.class, example = "juan.perez@example.com")
    @JsonbProperty("email")
    public String email;

    @Column(name = "fecha_creacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_ultima_actualizacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaActualizacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime  fechaActualizacion;

    @Column(name = "usuario_creo_registro")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "usuario_ultima_actualizacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_persona")
    @Schema(required = true, implementation = Entity_TipoPersona.class, example = "1")
    @JsonbProperty("id_tipo_persona")
    private Entity_TipoPersona tipo_persona;

    @Column(name = "id_persona_legacy")
    @Schema(required = false, implementation = String.class, example = "1")
    @JsonbProperty("idPersonaLegacy")
    private String idPersonaLegacy;

    @Column(name = "direccion")
    @Schema(required = false, implementation = String.class, example = "1")
    @JsonbProperty("direccion")
    public String direccion;
}
