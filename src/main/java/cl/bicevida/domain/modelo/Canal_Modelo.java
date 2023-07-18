package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "canal")
@Schema(description = "Entidad Canal")
public class Canal_Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    private Integer id;

    @Column(name = "nombre")
    @Schema(required = false, implementation = String.class, example = "Canal ABC")
    @JsonbProperty("nombre")
    private String nombre;

    @Column(name = "active")
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    private Boolean active;

    // Constructor vacío
    public Canal_Modelo() {
    }

    // Constructor con todos los campos
    public Canal_Modelo(Integer id, String nombre, Boolean active) {
        this.id = id;
        this.nombre = nombre;
        this.active = active;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
