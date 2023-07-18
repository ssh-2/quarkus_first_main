package cl.bicevida.Siniestro.domain.modelo;

import cl.bicevida.Estado.domain.modelo.Estado_Modelo;
import cl.bicevida.HomologacionCoberturaLegacy.domain.modelo.HomologacionCoberturaLegacy_Modelo;
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

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "siniestro")
public class Siniestro_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "id_homologacion_cobertura")
    @Schema(required = true, implementation = HomologacionCoberturaLegacy_Modelo.class)
    @JsonbProperty("homologacion_cobertura")
    public HomologacionCoberturaLegacy_Modelo homologacionCobertura;

    @Column(name = "numero_poliza")
    @Schema(required = false, implementation = String.class, example = "12345")
    @JsonbProperty("numero_poliza")
    public String numeroPoliza;

    @Column(name = "inicio_cobertura")
    @Schema(required = false, implementation = LocalDate.class, example = "2022-01-01")
    @JsonbProperty("inicio_cobertura")
    public LocalDate inicioCobertura;

    @Column(name = "fin_cobertura")
    @Schema(required = false, implementation = LocalDate.class, example = "2022-12-31")
    @JsonbProperty("fin_cobertura")
    public LocalDate finCobertura;

    @Column(name = "id_denuncio")
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_denuncio")
    public Integer idDenuncio;

    @Column(name = "capital_informado_legacy")
    @Schema(required = false, implementation = Double.class, example = "1000000.0")
    @JsonbProperty("capital_informado_legacy")
    public Double capitalInformadoLegacy;

    @Column(name = "monto_siniestrado")
    @Schema(required = false, implementation = Double.class, example = "500000.0")
    @JsonbProperty("monto_siniestrado")
    public Double montoSiniestrado;

    @Column(name = "is_uf")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("is_uf")
    public Boolean isUf;

    @Column(name = "registro_cmf")
    @Schema(required = false, implementation = String.class, example = "123456")
    @JsonbProperty("registro_cmf")
    public String registroCmf;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    @Schema(required = true, implementation = Estado_Modelo.class)
    @JsonbProperty("estado")
    public Estado_Modelo estado;

    @Column(name = "fecha_estado")
    @Schema(required = false, implementation = LocalDate.class, example = "2022-01-01")
    @JsonbProperty("fecha_estado")
    public LocalDate fechaEstado;

    @Column(name = "observacion")
    @Schema(required = false, implementation = String.class, example = "Observación sobre el siniestro")
    @JsonbProperty("observacion")
    public String observacion;

    @Column(name = "causa")
    @Schema(required = false, implementation = String.class, example = "Causa del siniestro")
    @JsonbProperty("causa")
    public String causa;

    @Column(name = "fundamento_legal")
    @Schema(required = false, implementation = String.class, example = "Fundamento legal del siniestro")
    @JsonbProperty("fundamento_legal")
    public String fundamentoLegal;
}
