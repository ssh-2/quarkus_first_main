package cl.bicevida.LiquidacionesDetalle.domain.modelo;

import cl.bicevida.AnticipoPagoFuturo.domain.modelo.AnticipoPagoFuturo_Modelo;
import cl.bicevida.Beneficiario.domain.modelo.Beneficiario_Modelo;
import cl.bicevida.Estado.domain.modelo.Estado_Modelo;
import cl.bicevida.Liquidaciones.domain.modelo.Liquidaciones_Modelo;
import cl.bicevida.MotivoReversa.domain.modelo.MotivoReversa_Modelo;
import cl.bicevida.NivelEscolaridad.domain.modelo.NivelEscolaridad_Modelo;
import cl.bicevida.TipoMedioPago.domain.modelo.TipoMedioPago_Modelo;
import cl.bicevida.TipoPagoLiquidacion.domain.modelo.TipoPagoLiquidacion_Modelo;
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
@Table(name = "liquidaciones_detalle")
public class LiquidacionesDetalle_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    @Schema(required = true, implementation = Estado_Modelo.class)
    @JsonbProperty("estado")
    public Estado_Modelo estado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago_liquidacion")
    @Schema(required = true, implementation = TipoPagoLiquidacion_Modelo.class)
    @JsonbProperty("tipo_pago_liquidacion")
    public TipoPagoLiquidacion_Modelo tipoPagoLiquidacion;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario")
    @Schema(required = true, implementation = Beneficiario_Modelo.class)
    @JsonbProperty("beneficiario")
    public Beneficiario_Modelo beneficiario;

    @ManyToOne
    @JoinColumn(name = "id_nivel_escolaridad")
    @Schema(required = true, implementation = NivelEscolaridad_Modelo.class)
    @JsonbProperty("nivel_escolaridad")
    public NivelEscolaridad_Modelo nivelEscolaridad;

    @Column(name = "monto_uf", nullable = true)
    @Schema(required = false, implementation = Double.class, example = "150.0")
    @JsonbProperty("monto_uf")
    public Double montoUF;

    @Column(name = "monto_liquidacion", nullable = true)
    @Schema(required = false, implementation = Double.class, example = "20000.0")
    @JsonbProperty("monto_liquidacion")
    public Double montoLiquidacion;

    @Column(name = "monto_provision", nullable = true)
    @Schema(required = false, implementation = Double.class, example = "5000.0")
    @JsonbProperty("monto_provision")
    public Double montoProvision;

    @Column(name = "fecha_pago", nullable = true)
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fecha_pago")
    public Date fechaPago;

    @Column(name = "correlativo", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("correlativo")
    public Integer correlativo;

    @Column(name = "pago_comercial", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("pago_comercial")
    public Boolean pagoComercial;

    @Column(name = "fecha_anulacion", nullable = true)
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fecha_anulacion")
    public Date fechaAnulacion;

    @ManyToOne
    @JoinColumn(name = "id_via_pago")
    @Schema(required = true, implementation = TipoMedioPago_Modelo.class)
    @JsonbProperty("via_pago")
    public TipoMedioPago_Modelo viaPago;

    @ManyToOne
    @JoinColumn(name = "id_anticipo_pago_futuro")
    @Schema(required = true, implementation = AnticipoPagoFuturo_Modelo.class)
    @JsonbProperty("anticipo_pago_futuro")
    public AnticipoPagoFuturo_Modelo anticipoPagoFuturo;

    @ManyToOne
    @JoinColumn(name = "id_liquidacion")
    @Schema(required = true, implementation = Liquidaciones_Modelo.class)
    @JsonbProperty("liquidacion")
    public Liquidaciones_Modelo liquidacion;

    @Column(name = "status", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("status")
    public Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_motivo_reversa")
    @Schema(required = true, implementation = MotivoReversa_Modelo.class)
    @JsonbProperty("motivo_reversa")
    public MotivoReversa_Modelo motivoReversa;

    @Column(name = "fecha_estado", nullable = true)
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fecha_estado")
    public Date fechaEstado;
}
