package Canal.domain.modelo;
package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "canal")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
