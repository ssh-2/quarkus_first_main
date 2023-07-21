package cl.bicevida.NivelEscolaridad.domain.modelo;

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
@Table(name = "nivel_escolaridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NivelEscolaridad_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "Nivel de escolaridad")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "correlativo")
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("correlativo")
    public Long correlativo;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
