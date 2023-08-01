package cl.bicevida.HomologacionCoberturaLegacy.domain.DTO;

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
public class Response_DTO_HomologacionCoberturaLegacy {

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id")
    public Long id;

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id_cobertura_legacy")
    public Long idCoberturaLegacy;

    @Schema(required = true, implementation = Long.class, example = "1")
    @JsonbProperty("id_linea_negocio_legacy")
    public Long idLineaNegocioLegacy;

    @Schema(required = true, implementation = String.class, example = "Registro CMF")
    @JsonbProperty("registroCmf")
    public String registroCMF;

}
