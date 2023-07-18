package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "cie")
public class Cie_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "descripcion")
    @Schema(required = true, implementation = String.class, example = "Descripción del CIE")
    @JsonbProperty("descripcion")
    public String descripcion;

    @Column(name = "codigo_cie")
    @Schema(required = true, implementation = String.class, example = "Código del CIE")
    @JsonbProperty("codigo_cie")
    public String codigoCie;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    public Cie_Modelo() {}

    public Cie_Modelo(Integer id, String descripcion, String codigoCie, Boolean active) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigoCie = codigoCie;
        this.active = active;
    }
}
