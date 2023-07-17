package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="PAIS", schema = "PERSONAS")
@Schema(
        description = "(Descripción del esquema de datos) payload PAIS",
        name = "PAIS (nombre del esquema)"
)
public class Pais_Modelo {

    @Id
    @Column(name = "CODIGO_PAIS")
    @Schema(required = true, implementation = long.class, example = "56")
    @JsonbProperty("codigo_pais")
    public long codigoPais;
    @Column(name = "CODIGO_NEMOTECNICO")
    @Schema(required = false, implementation = String.class, example = "56", nullable = true)
    @JsonbProperty("codigo_nemotecnico")
    public String codigoNemotecnico;
    @Column(name = "NOMBRE")
    @Schema(required = true, implementation = String.class, example = "CHILE", nullable = false)
    @JsonbProperty("nombre")
    public String nombre;
    @Column(name = "CODIGO_TELEFONICO")
    @Schema(required = false, implementation = String.class, example = "56", nullable = true, maxLength = 16)
    @JsonbProperty("codigo_telefonico")
    public String codigoTelefonico;

    @Column(name = "SYS_ID")
    @Schema(required = true, implementation = int.class, example = "0", nullable = false)
    @JsonbProperty("sys_id")
    public int sysId;
    @Column(name = "SYS_USUARIO")
    @Schema(required = true, implementation = String.class, example = "INIT", nullable = false)
    @JsonbProperty("usuario")
    public String sysUsuario;
    @Column(name = "SYS_APLICACION")
    @Schema(required = true, implementation = String.class, example = "INIT", nullable = false)
    @JsonbProperty("aplicacion")
    public String sysAplicacion;
    @Column(name = "SYS_ACCION")
    @Schema(required = true, implementation = String.class, example = "INSERT", nullable = false)
    @JsonbProperty("accion")
    public String sysAccion;
    @Column(name = "SYS_VERSION")
    @Schema(required = true, implementation = int.class, example = "0", nullable = false)
    @JsonbProperty("version")
    public int sysVersion;
    @Column(name = "SYS_FECHA_MODIFICACION")
    @Schema(implementation = Date.class, example = "2023-06-07 15:45:29.791", required = true)
    //@JsonbDateFormat(value = "yyyy-MM-dd")
    @JsonbProperty("fecha_modificacion")
    public LocalDateTime sysFechaMoficiacion;
    @Column(name = "SYS_TIPO")
    @Schema(required = false, implementation = String.class, example = "PAIS", nullable = false)
    @JsonbProperty("tipo")
    public String sysTipo;
    @Column(name = "SYS_ELIMINADO")
    @Schema(required = true, implementation = int.class, example = "0", nullable = false)
    @JsonbProperty("eliminado")
    public int sysEliminado;
    @Column(name = "CRM_NOMBRE")
    @Schema(required = false, implementation = String.class, example = "Sin Clasificar", nullable = true)
    @JsonbProperty("nombre_crm")
    public String crmNombre;
    @Column(name = "CT_NOMBRE")
    @Schema(required = false, implementation = String.class, example = "CHILE", nullable = true)
    @JsonbProperty("nombre_ct")
    public String ctNombre;

    public Pais_Modelo(){}

    public Pais_Modelo(long CODIGO_PAIS, String NOMBRE){
        this.codigoPais = CODIGO_PAIS;
        this.nombre = NOMBRE;
        this.sysId = 0;
        this.sysUsuario = "INIT";
        this.sysAplicacion = "INIT";
        this.sysAccion = "INSERT";
        this.sysVersion = 0;
        this.sysFechaMoficiacion = LocalDateTime.now();
        this.sysEliminado = 0;
    }

}
