package cl.bicevida.Canal.domain.modelo;

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

import java.util.Date;

@Entity
@Table(name = "canal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Canal_Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    private long id;

    @Column(name = "nombre")
    @Schema(required = false, implementation = String.class, example = "Canal ABC")
    @JsonbProperty("nombre")
    private String nombre;

    @Column(name = "active")
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    private Boolean active;

    @Column(name = "fecha_creacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "usuario_creacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "usuario_actualizacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuario_actualizacion")
    private String usuarioActualizacion;

}
