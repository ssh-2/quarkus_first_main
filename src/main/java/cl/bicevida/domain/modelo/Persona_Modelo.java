package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "rut")
    @Schema(required = true, implementation = String.class, example = "12345678-9")
    @JsonbProperty("rut")
    public String rut;

    @Column(name = "dv")
    @Schema(required = true, implementation = String.class, example = "9")
    @JsonbProperty("dv")
    public String dv;

    @Column(name = "nombres_Razon_Social")
    @Schema(required = true, implementation = String.class, example = "Juan Carlos")
    @JsonbProperty("nombres_Razon_Social")
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
    @JsonbProperty("fecha_Nacimiento")
    public LocalDateTime fechaNacimiento;

    @Column(name = "sexo")
    @Schema(required = true, implementation = String.class, example = "Masculino")
    @JsonbProperty("sexo")
    public String sexo;

    @Column(name = "email")
    @Schema(required = true, implementation = String.class, example = "juan.perez@example.com")
    @JsonbProperty("email")
    public String email;
}
