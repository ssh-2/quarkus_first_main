package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "liquidaciones")
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

    // Constructor vacío
    public Liquidaciones_Modelo() {}

    // Constructor con todos los campos
    public Liquidaciones_Modelo(Integer id, Integer idSiniestro) {
        this.id = id;
        this.idSiniestro = idSiniestro;
    }
}
