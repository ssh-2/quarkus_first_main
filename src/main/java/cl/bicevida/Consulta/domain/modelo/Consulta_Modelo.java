package cl.bicevida.Consulta.domain.modelo;

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
@Table(name = "consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "id_tipo_consulta", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_tipo_consulta")
    public Integer idTipoConsulta;

    @Column(name = "descripcion", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Descripción de la consulta")
    @JsonbProperty("descripcion")
    public String descripcion;

    @Column(name = "active", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @Column(name = "id_denuncio", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_denuncio")
    public Integer idDenuncio;

    @Column(name = "rol", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Rol de la consulta")
    @JsonbProperty("rol")
    public String rol;

    @Column(name = "fecha", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha")
    public LocalDate fecha;
}
