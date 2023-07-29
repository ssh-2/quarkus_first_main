package cl.bicevida.Liquidador.domain.DTO;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response_DTO_Liquidador {

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Schema(required = true , implementation = String.class, example = "Natural")
    @JsonbProperty("nombre")
    public String nombre;

    @Schema(required = true, implementation = String.class, example = "elmakina@gmail.com")
    @JsonbProperty("email")
    public String email;
}
