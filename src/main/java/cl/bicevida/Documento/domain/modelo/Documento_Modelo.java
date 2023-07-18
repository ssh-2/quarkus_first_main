package cl.bicevida.Documento.domain.modelo;

import cl.bicevida.Denuncio.domain.modelo.Denuncio_Modelo;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;

@Entity
@Table(name = "documentos")
@Data
public class Documento_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class)
    @JsonbProperty("id")
    public Integer id;

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
