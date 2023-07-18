package cl.bicevida.domain.modelo;

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

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diagnostico")
public class Diagnostico_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cie")
    @Schema(required = true, implementation = Cie_Modelo.class)
    @JsonbProperty("cie")
    public Cie_Modelo cie;

    @ManyToOne
    @JoinColumn(name = "id_siniestro")
    @Schema(required = true, implementation = Siniestro_Modelo.class)
    @JsonbProperty("siniestro")
    public Siniestro_Modelo siniestro;

    @ManyToOne
    @JoinColumn(name = "id_precedencia")
    @Schema(required = true, implementation = Precedencia_Modelo.class)
    @JsonbProperty("precedencia")
    public Precedencia_Modelo precedencia;

    @Column(name = "fecha")
    @Schema(required = true, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fecha")
    public Date fecha;

    @Column(name = "estado")
    @Schema(required = false, implementation = String.class, example = "En proceso")
    @JsonbProperty("estado")
    public String estado;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;
}
