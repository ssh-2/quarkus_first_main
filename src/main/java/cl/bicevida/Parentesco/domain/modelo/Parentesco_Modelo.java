package cl.bicevida.Parentesco.domain.modelo;

import cl.bicevida.Persona.domain.modelo.Persona_Modelo;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
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
@Table(name = "parentesco")
public class Parentesco_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_pariente")
    @Schema(required = true, implementation = Persona_Modelo.class)
    @JsonbProperty("pariente")
    public Persona_Modelo pariente;

    @ManyToOne
    @JoinColumn(name = "id_pariente_relacion")
    @Schema(required = true, implementation = Persona_Modelo.class)
    @JsonbProperty("pariente_relacion")
    public Persona_Modelo parienteRelacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_parentesco")
    @Schema(required = true, implementation = Entity_TipoParentesco.class)
    @JsonbProperty("tipo_parentesco")
    public Entity_TipoParentesco tipoParentesco;

    @Column(name = "vigente")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("vigente")
    public Boolean vigente;

    @Column(name = "participacion")
    @Schema(required = true, implementation = Double.class, example = "0.5")
    @JsonbProperty("participacion")
    public Double participacion;

    @Column(name = "comentario")
    @Schema(required = false, implementation = String.class, example = "Comentario sobre el parentesco")
    @JsonbProperty("comentario")
    public String comentario;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
