package cl.bicevida.TipoDenuncio.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_denuncio")
public class Entity_TipoDenucio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "Robo")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @Column(name = "fecha_creacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_ultima_actualizacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "usuario_creo_registro")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "usuario_ultima_actualizacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;

}
