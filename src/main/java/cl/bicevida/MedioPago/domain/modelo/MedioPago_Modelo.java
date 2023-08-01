package cl.bicevida.MedioPago.domain.modelo;

import cl.bicevida.Banco.domain.modelo.Entity_Banco;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import cl.bicevida.TipoMedioPago.domain.modelo.TipoMedioPago_Modelo;
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
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_medio_pago")
    @Schema(required = true, implementation = TipoMedioPago_Modelo.class)
    @JsonbProperty("tipo_medio_pago")
    public TipoMedioPago_Modelo tipoMedioPago;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta_banco")
    @Schema(required = true, implementation = Entity_TipoCuentaBanco.class)
    @JsonbProperty("tipo_cuenta_banco")
    public Entity_TipoCuentaBanco tipoCuentaBanco;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    @Schema(required = true, implementation = Entity_Banco.class)
    @JsonbProperty("banco")
    public Entity_Banco banco;

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
    @Schema(required = true, implementation = Entity_Persona.class)
    @JsonbProperty("persona")
    public Entity_Persona persona;

    @Column(name = "seleccionada")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("seleccionada")
    public Boolean seleccionada;
}
