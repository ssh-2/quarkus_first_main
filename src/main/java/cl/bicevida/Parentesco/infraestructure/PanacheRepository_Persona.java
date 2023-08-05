package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static cl.bicevida.Utils.Constants.DATA_NO_ENCONTRADA;

@ApplicationScoped
@Slf4j
public class PanacheRepository_Persona implements PanacheRepository<Entity_Persona> {

    public PanacheRepository_Persona() {
    }

    public Entity_Persona consultarPorRut(String rut) {
        log.info("Consultado si existe el rut: " + rut);
        return find("rut", rut).firstResult();
    }


    public PanacheQuery<Entity_Persona> buscarPaginadoParametrosOpcionales(String rut, String dv, String nombre, String idPersonaLegacy, int paginaActual, int cantidadElementos) {
        Map<String, Object> parameters = new HashMap<>();
        addIfNotNull(parameters, "rut", rut);
        addIfNotNull(parameters, "dv", dv);
        addIfNotNull(parameters, "nombresRazonSocial", nombre);
        addIfNotNull(parameters, "idPersonaLegacy", idPersonaLegacy);

        if (!parameters.isEmpty()) {
            String query = parameters.keySet().stream()
                    .map(o -> o + "=:" + o)
                    .collect(Collectors.joining(" and "));


            paginaActual = paginaActual - 1;
            if (paginaActual < 0) {
                paginaActual = 0;
            }
            if (cantidadElementos <= 0) {
                cantidadElementos = 1;
            }
            return find(query, parameters).page(paginaActual, cantidadElementos);

        }

        throw new NotFoundException(DATA_NO_ENCONTRADA);
    }

    private static void addIfNotNull(Map<String, Object> map, String key, String value) {
        if (value != null) {
            map.put(key, value);
        }
    }

}
