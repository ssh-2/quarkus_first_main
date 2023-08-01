package cl.bicevida.Utils;

import jakarta.json.bind.annotation.JsonbProperty;
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
public class PaginadoRequest {

    private final String elementosJson = "cantidadElementos";

    private final String numeroPaginaJson = "numeroPagina";

    private final int minimo = 1;
    private final int maximo = 15;

    @NotNull(message = elementosJson + ES_REQUERIDO)
    @Size(min = minimo, max = maximo ,message = elementosJson + DEBE_POSEER_MINIMO + minimo + DEBE_POSEER_MAXIMO + maximo)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = elementosJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = String.class, example = "5")
    @JsonbProperty(elementosJson)
    private int cantidadElementos;

    @NotNull(message = numeroPaginaJson + ES_REQUERIDO)
    @Size(min = minimo, max = maximo ,message = numeroPaginaJson + DEBE_POSEER_MINIMO + minimo + DEBE_POSEER_MAXIMO + maximo)
    @Pattern(regexp  = REGEX_SOLO_NUMEROS,message = numeroPaginaJson + ERROR_FORMATO_SOLO_NUMEROS)
    @Schema(required = true, implementation = String.class, example = "1")
    @JsonbProperty(numeroPaginaJson)
    private int numeroPagina;
}
