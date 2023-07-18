package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "nivel_escolaridad")
public class NivelEscolaridad_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "Nivel de escolaridad")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "correlativo")
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("correlativo")
    public Integer correlativo;

    @Column(name = "status")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("status")
    public Boolean status;

    // Constructor vacío
    public NivelEscolaridad_Modelo() {}

    // Constructor con todos los campos
    public NivelEscolaridad_Modelo(Integer id, String nombre, Integer correlativo, Boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.correlativo = correlativo;
        this.status = status;
    }
}
