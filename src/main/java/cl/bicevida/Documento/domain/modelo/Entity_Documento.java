package cl.bicevida.Documento.domain.modelo;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "documentos")
@Data
@Schema(
        description = "(Descripción del esquema de datos) payload Documento",
        name = "Documento (nombre del esquema)"
)
public class Entity_Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class)
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_denuncio", referencedColumnName = "id", foreignKey = @ForeignKey(name = "id_denuncio"))
    @JsonbProperty("denuncio")
    public Entity_Denucio denuncio;

    @Column(name = "descripcion", nullable = true)
    @Schema(required = false, implementation = String.class)
    @JsonbProperty("descripcion")
    public String descripcion;

    @Column(name = "active", nullable = true)
    @Schema(required = false, implementation = Boolean.class)
    @JsonbProperty("active")
    public Boolean active;

    @Column(name = "path", nullable = true)
    @Schema(required = false, implementation = String.class)
    @JsonbProperty("path")
    public String path;

    @Column(name = "fecha_creacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_ultima_actualizacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaActualizacion")
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
