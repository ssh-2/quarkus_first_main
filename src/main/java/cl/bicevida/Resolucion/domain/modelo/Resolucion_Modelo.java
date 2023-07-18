package cl.bicevida.Resolucion.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resolucion")
public class Resolucion_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "causa", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Falta de documentación requerida")
    @JsonbProperty("causa")
    public String causa;

    @Column(name = "fundamento_legal", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Ley de Seguros N° 1234")
    @JsonbProperty("fundamento_legal")
    public String fundamentoLegal;

    @Column(name = "id_estado_resolucion", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_estado_resolucion")
    public Integer idEstadoResolucion;

    @Column(name = "id_tipo_rechazo", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_tipo_rechazo")
    public Integer idTipoRechazo;

    @Column(name = "id_siniestro", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_siniestro")
    public Integer idSiniestro;

    @Column(name = "active", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
