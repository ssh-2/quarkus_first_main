package cl.bicevida.Liquidaciones.domain.modelo;

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
@Table(name = "liquidaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liquidaciones_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "id_siniestro")
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id_siniestro")
    public Integer idSiniestro;
}
