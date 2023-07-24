package cl.bicevida.TipoConsulta.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "tipo_consulta")
public class TipoConsulta_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "nombre")
    @Schema(required = true, implementation = String.class, example = "Consulta")
    @JsonbProperty("nombre")
    public String nombre;

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
