package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "motivo_reversa")
public class MotivoReversa_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "descripcion")
    @Schema(required = true, implementation = String.class, example = "Motivo de reversa")
    @JsonbProperty("descripcion")
    public String descripcion;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    // Constructor vacío
    public MotivoReversa_Modelo() {}

    // Constructor con todos los campos
    public MotivoReversa_Modelo(Integer id, String descripcion, Boolean active) {
        this.id = id;
        this.descripcion = descripcion;
        this.active = active;
    }
}
