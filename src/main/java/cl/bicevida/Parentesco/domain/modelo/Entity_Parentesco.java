package cl.bicevida.Parentesco.domain.modelo;

import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.TipoParentesco.domain.modelo.Entity_TipoParentesco;
import com.fasterxml.jackson.annotation.JsonFormat;
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

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parentesco")
public class Entity_Parentesco {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_pariente")
    @Schema(required = true, implementation = Entity_Persona.class)
    @JsonbProperty("pariente")
    public Entity_Persona pariente;

    @ManyToOne
    @JoinColumn(name = "id_pariente_relacion")
    @Schema(required = true, implementation = Entity_Persona.class)
    @JsonbProperty("pariente_relacion")
    public Entity_Persona parienteRelacion;

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

    @Column(name = "fecha_creacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_ultima_actualizacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaActualizacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime  fechaActualizacion;

    @Column(name = "usuario_creo_registro")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "usuario_ultima_actualizacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;
}
