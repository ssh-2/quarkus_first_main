package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Entity
@Table(name = "denuncio")
public class Denuncio_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "fecha_ocurrencia", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha_ocurrencia")
    public LocalDate fechaOcurrencia;

    @Column(name = "fecha_conocimiento", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha_conocimiento")
    public LocalDate fechaConocimiento;

    @Column(name = "fecha_notificacion", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha_notificacion")
    public LocalDate fechaNotificacion;

    @Column(name = "descripcion_hechos", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Descripción de los hechos del denuncio")
    @JsonbProperty("descripcion_hechos")
    public String descripcionHechos;

    @Column(name = "id_tipo_denuncio", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_tipo_denuncio")
    public Integer idTipoDenuncio;

    @Column(name = "id_estado", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_estado")
    public Integer idEstado;

    @Column(name = "id_denunciante", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_denunciante")
    public Integer idDenunciante;

    @Column(name = "id_siniestrado", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_siniestrado")
    public Integer idSiniestrado;

    @Column(name = "id_titular", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_titular")
    public Integer idTitular;

    @Column(name = "id_canal", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_canal")
    public Integer idCanal;

    @Column(name = "tipo_ingreso", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Tipo de ingreso del denuncio")
    @JsonbProperty("tipo_ingreso")
    public String tipoIngreso;

    @Column(name = "id_linea_negocio", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_linea_negocio")
    public Integer idLineaNegocio;

    @Column(name = "prefijo_poliza", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "123")
    @JsonbProperty("prefijo_poliza")
    public Integer prefijoPoliza;

    @Column(name = "numero_poliza", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "456")
    @JsonbProperty("numero_poliza")
    public Integer numeroPoliza;

    @Column(name = "secuencia_poliza", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "789")
    @JsonbProperty("secuencia_poliza")
    public Integer secuenciaPoliza;

    @Column(name = "producto", nullable = true)
    @Schema(required = false, implementation = String.class, example = "Producto asociado al denuncio")
    @JsonbProperty("producto")
    public String producto;

    @Column(name = "inicio_poliza", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("inicio_poliza")
    public LocalDate inicioPoliza;

    @Column(name = "termino_poliza", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("termino_poliza")
    public LocalDate terminoPoliza;

    @Column(name = "id_liquidador", nullable = true)
    @Schema(required = false, implementation = Integer.class, example = "1")
    @JsonbProperty("id_liquidador")
    public Integer idLiquidador;

    @Column(name = "active", nullable = true)
    @Schema(required = false, implementation = Boolean.class, example = "true")
    @JsonbProperty("active")
    public Boolean active;

    @Column(name = "fecha_estado", nullable = true)
    @Schema(required = false, implementation = LocalDate.class, example = "2023-07-17")
    @JsonbProperty("fecha_estado")
    public LocalDate fechaEstado;

    // Constructor vacío
    public Denuncio_Modelo() {
    }

    // Constructor con todos los campos
    public Denuncio_Modelo(Integer id, LocalDate fechaOcurrencia, LocalDate fechaConocimiento, LocalDate fechaNotificacion,
                           String descripcionHechos, Integer idTipoDenuncio, Integer idEstado, Integer idDenunciante,
                           Integer idSiniestrado, Integer idTitular, Integer idCanal, String tipoIngreso,
                           Integer idLineaNegocio, Integer prefijoPoliza, Integer numeroPoliza,
                           Integer secuenciaPoliza, String producto, LocalDate inicioPoliza, LocalDate terminoPoliza,
                           Integer idLiquidador, Boolean active, LocalDate fechaEstado) {
        this.id = id;
        this.fechaOcurrencia = fechaOcurrencia;
        this.fechaConocimiento = fechaConocimiento;
        this.fechaNotificacion = fechaNotificacion;
        this.descripcionHechos = descripcionHechos;
        this.idTipoDenuncio = idTipoDenuncio;
        this.idEstado = idEstado;
        this.idDenunciante = idDenunciante;
        this.idSiniestrado = idSiniestrado;
        this.idTitular = idTitular;
        this.idCanal = idCanal;
        this.tipoIngreso = tipoIngreso;
        this.idLineaNegocio = idLineaNegocio;
        this.prefijoPoliza = prefijoPoliza;
        this.numeroPoliza = numeroPoliza;
        this.secuenciaPoliza = secuenciaPoliza;
        this.producto = producto;
        this.inicioPoliza = inicioPoliza;
        this.terminoPoliza = terminoPoliza;
        this.idLiquidador = idLiquidador;
        this.active = active;
        this.fechaEstado = fechaEstado;
    }
}
