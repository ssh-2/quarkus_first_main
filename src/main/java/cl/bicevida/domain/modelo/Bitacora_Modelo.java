package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "bitacora")
public class Bitacora_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "table")
    @Schema(required = true, implementation = String.class, example = "Table")
    @JsonbProperty("table")
    public String table;

    @Column(name = "id_registro")
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id_registro")
    public Integer idRegistro;

    @Column(name = "accion")
    @Schema(required = true, implementation = String.class, example = "INSERT")
    @JsonbProperty("accion")
    public String accion;

    @Column(name = "usuario")
    @Schema(required = true, implementation = String.class, example = "admin")
    @JsonbProperty("usuario")
    public String usuario;

    @ManyToOne
    @JoinColumn(name = "id_table", referencedColumnName = "id")
    @JsonbProperty("id_table")
    public Table_Modelo idTable;

    // Constructor vacío
    public Bitacora_Modelo() {}

    // Constructor con todos los campos
    public Bitacora_Modelo(Integer id, String table, Integer idRegistro, String accion, String usuario, Table_Modelo idTable) {
        this.id = id;
        this.table = table;
        this.idRegistro = idRegistro;
        this.accion = accion;
        this.usuario = usuario;
        this.idTable = idTable;
    }
}
