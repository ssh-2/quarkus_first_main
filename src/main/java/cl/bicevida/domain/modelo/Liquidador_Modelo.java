package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "liquidador")
public class Liquidador_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "John Doe")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "email")
    @Schema(required = true, implementation = String.class, example = "john.doe@example.com")
    @JsonbProperty("email")
    public String email;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    // Constructor vacío
    public Liquidador_Modelo() {}

    // Constructor con todos los campos
    public Liquidador_Modelo(Integer id, String nombre, String email, Boolean active) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.active = active;
    }
}
