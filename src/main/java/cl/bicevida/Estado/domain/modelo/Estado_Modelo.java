package cl.bicevida.Estado.domain.modelo;

import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "estados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

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
    public Entity_ProcesoEstado procesoEstado;
}
