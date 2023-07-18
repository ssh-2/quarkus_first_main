package ConsultaRespuesta.domain.modelo;
package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Entity
@Table(name = "consulta_respuesta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRespuesta_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "descripcion", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Descripción de la respuesta de la consulta")
    @JsonbProperty("descripcion")
    public String descripcion;

    @Column(name = "active", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @Column(name = "id_consulta", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_consulta")
    public Integer idConsulta;

    @Column(name = "rol", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Rol de la respuesta de la consulta")
    @JsonbProperty("rol")
    public String rol;

    @Column(name = "fecha", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha")
    public LocalDate fecha;
}
