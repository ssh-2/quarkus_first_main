package cl.bicevida.Documento.domain.modelo;

import cl.bicevida.Denuncio.domain.modelo.Denuncio_Modelo;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;

@Entity
@Table(name = "documentos")
@Data
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
    public Denuncio_Modelo denuncio;

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
}
