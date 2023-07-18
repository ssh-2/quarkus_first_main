package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Entity
@Table(name = "anticipo_pago_futuro")
@Schema(description = "Entidad AnticipoPagoFuturo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnticipoPagoFuturo_Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    private Integer id;

    @Column(name = "id_beneficiario")
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_beneficiario")
    private Integer idBeneficiario;

    @Column(name = "fecha")
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    @JsonbProperty("fecha")
    private LocalDate fecha;

    @Column(name = "tasa_actual")
    @Schema(required = false, implementation = Integer.class, example = "5")
    @JsonbProperty("tasa_actual")
    private Integer tasaActual;

    @Column(name = "years_pendientes")
    @Schema(required = false, implementation = Integer.class, example = "10")
    @JsonbProperty("years_pendientes")
    private Integer yearsPendientes;

    @Column(name = "capital_anual_uf")
    @Schema(required = false, implementation = Double.class, example = "1000.0")
    @JsonbProperty("capital_anual_uf")
    private Double capitalAnualUF;

    @Column(name = "a_pagar_uf")
    @Schema(required = false, implementation = Double.class, example = "5000.0")
    @JsonbProperty("a_pagar_uf")
    private Double aPagarUF;

    @Column(name = "status")
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("status")
    private Boolean status;
}
