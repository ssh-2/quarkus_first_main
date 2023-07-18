package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "estado_resolucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoResolucion_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "Nombre del Estado de Resolución")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
