package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "tipo_pago_liquidacion")
public class TipoPagoLiquidacion_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "nombre", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Transferencia bancaria")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "status", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("status")
    public Boolean status;

    // Constructor vacío
    public TipoPagoLiquidacion_Modelo() {}

    // Constructor con todos los campos
    public TipoPagoLiquidacion_Modelo(Integer id, String nombre, Boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.status = status;
    }
}
