package cl.bicevida.HomologacionCoberturaLegacy.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "homologacion_cobertura_legacy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity_HomologacionCoberturaLegacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Column(name = "id_cobertura_legacy")
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("idCoberturaLegacy")
    public Long idCoberturaLegacy;

    @Column(name = "registro_cmf")
    @Schema(required = true, implementation = String.class, example = "Registro CMF")
    @JsonbProperty("registroCmf")
    public String registroCMF;

    @Column(name = "id_linea_negocio_legacy")
    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("idLineaNegocioLegacy")
    public Long idLineaNegocioLegacy;

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
    private LocalDateTime  fechaActualizacion;

    @Column(name = "usuario_creo_registro")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioCreacion")
    private String usuarioCreacion;

    @Column(name = "usuario_ultima_actualizacion")
    @Schema(required = false, implementation = String.class, example = "user123")
    @JsonbProperty("usuarioActualizacion")
    private String usuarioActualizacion;
}
