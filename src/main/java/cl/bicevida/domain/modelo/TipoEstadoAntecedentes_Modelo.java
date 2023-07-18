package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "tipo_estado_antecedentes")
public class TipoEstadoAntecedentes_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "nombre", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Aprobado")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "active", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    // Constructor vacío
    public TipoEstadoAntecedentes_Modelo() {}

    // Constructor con todos los campos
    public TipoEstadoAntecedentes_Modelo(Integer id, String nombre, Boolean active) {
        this.id = id;
        this.nombre = nombre;
        this.active = active;
    }
}
