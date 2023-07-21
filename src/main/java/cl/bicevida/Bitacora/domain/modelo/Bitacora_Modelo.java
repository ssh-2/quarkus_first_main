package cl.bicevida.Bitacora.domain.modelo;

import cl.bicevida.Table.domain.modelo.Table_Modelo;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "bitacora")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
