package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Entity
@Table(name = "denuncio_antecedente")
public class DenuncioAntecedente_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

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

    // Constructor vacío
    public DenuncioAntecedente_Modelo() {}

    // Constructor con todos los campos
    public DenuncioAntecedente_Modelo(Integer id, Denuncio_Modelo denuncio, TipoAntecedentes_Modelo tipoAntecedentes,
                                      TipoEstadoAntecedentes_Modelo tipoEstadoAntecedente, String observacion,
                                      LocalDate fechaRecepcion, LocalDate fechaCreacion) {
        this.id = id;
        this.denuncio = denuncio;
        this.tipoAntecedentes = tipoAntecedentes;
        this.tipoEstadoAntecedente = tipoEstadoAntecedente;
        this.observacion = observacion;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaCreacion = fechaCreacion;
    }
}