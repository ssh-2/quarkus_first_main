package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "estados")
public class Estado_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "Estado")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_proceso_estado", referencedColumnName = "id")
    @JsonbProperty("proceso_estado")
    public ProcesoEstado_Modelo procesoEstado;

    // Constructor vacío
    public Estado_Modelo() {}

    // Constructor con todos los campos
    public Estado_Modelo(Integer id, String nombre, Boolean active, ProcesoEstado_Modelo procesoEstado) {
        this.id = id;
        this.nombre = nombre;
        this.active = active;
        this.procesoEstado = procesoEstado;
    }
}
