package cl.bicevida.TipoAntecedentesDenuncio.domain.modelo;

import cl.bicevida.TipoAntecedentes.domain.modelo.TipoAntecedentes_Modelo;
import cl.bicevida.TipoDenuncio.domain.modelo.TipoDenuncio_Modelo;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_antecedentes_denuncio")
public class TipoAntecedentesDenuncio_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_antecedente")
    @Schema(required = true, implementation = TipoAntecedentes_Modelo.class)
    @JsonbProperty("tipo_antecedente")
    public TipoAntecedentes_Modelo tipoAntecedente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_denuncio")
    @Schema(required = true, implementation = TipoDenuncio_Modelo.class)
    @JsonbProperty("tipo_denuncio")
    public TipoDenuncio_Modelo tipoDenuncio;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
