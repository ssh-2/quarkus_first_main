package cl.bicevida.Beneficiario.domain.modelo;

import cl.bicevida.MedioPago.domain.modelo.MedioPago_Modelo;
import cl.bicevida.Persona.domain.modelo.Persona_Modelo;
import cl.bicevida.Siniestro.domain.modelo.Siniestro_Modelo;
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
@Table(name = "beneficiario")
public class Beneficiario_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_siniestro")
    @Schema(required = true, implementation = Siniestro_Modelo.class)
    @JsonbProperty("siniestro")
    public Siniestro_Modelo siniestro;

    @ManyToOne
    @JoinColumn(name = "id_persona_beneficiario")
    @Schema(required = true, implementation = Persona_Modelo.class)
    @JsonbProperty("persona_beneficiario")
    public Persona_Modelo personaBeneficiario;

    @Column(name = "participacion")
    @Schema(required = false, implementation = Double.class, example = "0.5")
    @JsonbProperty("participacion")
    public Double participacion;

    @Column(name = "estado")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("estado")
    public Boolean estado;

    @Column(name = "comentario")
    @Schema(required = false, implementation = String.class, example = "Comentario sobre el beneficiario")
    @JsonbProperty("comentario")
    public String comentario;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_medio_pago")
    @Schema(required = true, implementation = MedioPago_Modelo.class)
    @JsonbProperty("medio_pago")
    public MedioPago_Modelo medioPago;
}
