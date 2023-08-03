package cl.bicevida.Utils;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonbPropertyOrder(value =  {"data","cantidadElementosEncontrados","cantidadDePaginas","tieneSiguientePagina","tienePaginaAnterior" })
public class PaginadoResponse {

    private Object data;
    private Long cantidadElementosEncontrados;
    private int cantidadDePaginas;
    private boolean tieneSiguientePagina;
    private boolean tienePaginaAnterior;
}
