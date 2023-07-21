package cl.bicevida.DenuncioAntecedente.domain.modelo;

import cl.bicevida.Denuncio.domain.modelo.Denuncio_Modelo;
import cl.bicevida.TipoAntecedentes.domain.modelo.TipoAntecedentes_Modelo;
import cl.bicevida.TipoEstadoAntecedentes.domain.modelo.TipoEstadoAntecedentes_Modelo;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Entity
@Table(name = "denuncio_antecedente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenuncioAntecedente_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_denuncio", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "id_denuncio_FK"))
    @Schema(required = false, implementation = Denuncio_Modelo.class)
    @JsonbProperty("id_denuncio")
    public Denuncio_Modelo denuncio;

    @ManyToOne
    @JoinColumn(name = "id_tipo_antecedente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "tipo_fk"))
    @Schema(required = false, implementation = TipoAntecedentes_Modelo.class)
    @JsonbProperty("id_tipo_antecedente")
    public TipoAntecedentes_Modelo tipoAntecedentes;

    @ManyToOne
    @JoinColumn(name = "id_tipo_estado_antecedente", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "tipo_antecedentes_fk"))
    @Schema(required = false, implementation = TipoEstadoAntecedentes_Modelo.class)
    @JsonbProperty("id_tipo_estado_antecedente")
    public TipoEstadoAntecedentes_Modelo tipoEstadoAntecedente;

    @Column(name = "observacion", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Observación del antecedente")
    @JsonbProperty("observacion")
    public String observacion;

    @Column(name = "fecha_recepcion", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha_recepcion")
    public LocalDate fechaRecepcion;

    @Column(name = "fecha_creacion", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha_creacion")
    public LocalDate fechaCreacion;
}
