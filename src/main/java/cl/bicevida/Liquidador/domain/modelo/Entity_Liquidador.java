package cl.bicevida.Liquidador.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

@Entity
@Table(name = "liquidador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity_Liquidador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    private Long id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "John Doe")
    @JsonbProperty("nombre")
    public String nombre;

    @Column(name = "email")
    @Schema(required = true, implementation = String.class, example = "john.doe@example.com")
    @JsonbProperty("email")
    public String email;

    @Column(name = "active")
    @Schema(required = true, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @Column(name = "fecha_creacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "fecha_ultima_actualizacion")
    @Schema(required = false, implementation = Date.class, example = "2023-07-17")
    @JsonbProperty("fechaActualizacion")
    private Date fechaActualizacion;

    @Column(name = "usuario_creo_registro")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "usuario_ultima_actualizacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;



}
