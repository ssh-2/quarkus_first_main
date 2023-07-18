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
@Table(name = "homologacion_cobertura_legacy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomologacionCoberturaLegacy_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "id_cobertura_legacy")
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id_cobertura_legacy")
    public Integer idCoberturaLegacy;

    @Column(name = "registro_cmf")
    @Schema(required = true, implementation = String.class, example = "Registro CMF")
    @JsonbProperty("registro_cmf")
    public String registroCMF;

    @Column(name = "id_linea_negocio_legacy")
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id_linea_negocio_legacy")
    public Integer idLineaNegocioLegacy;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
