package cl.bicevida.Cie.domain.modelo;

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
@Table(name = "cie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cie_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "descripcion")
    @Schema(required = true, implementation = String.class, example = "Descripción del CIE")
    @JsonbProperty("descripcion")
    public String descripcion;

    @Column(name = "codigo_cie")
    @Schema(required = true, implementation = String.class, example = "Código del CIE")
    @JsonbProperty("codigo_cie")
    public String codigoCie;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
