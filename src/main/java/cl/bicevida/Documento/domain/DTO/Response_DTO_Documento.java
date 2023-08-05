package cl.bicevida.Documento.domain.DTO;

import cl.bicevida.Denuncio.domain.modelo.Entity_Denucio;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static cl.bicevida.Utils.Constants.*;

@Getter
@Setter
@NoArgsConstructor
public class Response_DTO_Documento {

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @JsonbProperty("denuncio")
    public Entity_Denucio denuncio;

    @Schema(required = false, implementation = String.class)
    @JsonbProperty("descripcion")
    public String descripcion;

    @Schema(required = false, implementation = String.class)
    @JsonbProperty("path")
    public String path;
}
