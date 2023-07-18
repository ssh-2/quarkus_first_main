package MedioPago.domain.modelo;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medio_pago")
public class MedioPago_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_medio_pago")
    @Schema(required = true, implementation = TipoMedioPago_Modelo.class)
    @JsonbProperty("tipo_medio_pago")
    public TipoMedioPago_Modelo tipoMedioPago;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta_banco")
    @Schema(required = true, implementation = TipoCuentaBanco_Modelo.class)
    @JsonbProperty("tipo_cuenta_banco")
    public TipoCuentaBanco_Modelo tipoCuentaBanco;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    @Schema(required = true, implementation = Banco_Modelo.class)
    @JsonbProperty("banco")
    public Banco_Modelo banco;

    @Column(name = "numero_cuenta")
    @Schema(required = false, implementation = String.class, example = "1234567890")
    @JsonbProperty("numero_cuenta")
    public String numeroCuenta;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    @Schema(required = true, implementation = Persona_Modelo.class)
    @JsonbProperty("persona")
    public Persona_Modelo persona;

    @Column(name = "seleccionada")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("seleccionada")
    public Boolean seleccionada;
}
