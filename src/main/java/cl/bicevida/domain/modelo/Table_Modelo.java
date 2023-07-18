package cl.bicevida.domain.modelo;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Table(name = "tables")
public class Table_Modelo {
    @Id
    @Column(name = "id", nullable = false)
    @Schema(required = true, implementation = Integer.class, example = "1")
    @JsonbProperty("id")
    public Integer id;

    @Column(name = "name")
    @Schema(required = true, implementation = String.class, example = "Table")
    @JsonbProperty("name")
    public String name;

    // Constructor vacío
    public Table_Modelo() {}

    // Constructor con todos los campos
    public Table_Modelo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
