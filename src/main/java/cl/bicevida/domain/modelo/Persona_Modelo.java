package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Entity
@Table(name = "persona_TEST")
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    // Constructor vacío
    public Persona_Modelo() {}

    // Constructor con todos los campos
    public Persona_Modelo(Long id, String rut) {
        this.id = id;
        this.rut = rut;

    }
}
