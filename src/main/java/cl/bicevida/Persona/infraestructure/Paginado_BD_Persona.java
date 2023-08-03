package cl.bicevida.Persona.infraestructure;

import cl.bicevida.Persona.domain.DTO.Request_Paginado_DTO_Persona;
import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import cl.bicevida.Persona.domain.puertoSalida.PuertoSalida_Paginado_Persona;
import cl.bicevida.Persona.utils.Mapper_Persona;
import cl.bicevida.Utils.PaginadoResponse;
import cl.bicevida.Utils.RutValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.jboss.resteasy.spi.InternalServerErrorException;

import java.util.Optional;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Paginado_BD_Persona implements PuertoSalida_Paginado_Persona {

    private final PanacheRepository_Persona repository;
    private final Mapper_Persona mapper;

    private final RutValidation rutValidation;


    public Paginado_BD_Persona(PanacheRepository_Persona repository, Mapper_Persona mapper, RutValidation rutValidation) {
        this.repository = repository;
        this.mapper = mapper;
        this.rutValidation = rutValidation;
    }

    @Override
    @Retry(maxRetries = 3, delay = 3000, abortOn = {BadRequestException.class, NotFoundException.class, InternalServerErrorException.class})
    @Transactional
    public PaginadoResponse buscarPaginado(Request_Paginado_DTO_Persona dto) {
        String rut = Optional.ofNullable(dto.getRut()).orElse(null);
        String dv = Optional.ofNullable(dto.getDv()).orElse(null);
        String nombre = Optional.ofNullable(dto.getNombreRazonSocial()).orElse(null);
        String idPersonaLegacy = Optional.ofNullable(dto.getIdPersonaLegacy()).orElse(null);
        int paginaActual = DEFAULT_PAGINA_ACTUAL;
        int cantidadElementosPorPagina = DEFAULT_CANTIDAD_ELEMENTOS;

        if (dto.getPaginado() != null) {
            paginaActual = dto.getPaginado().getNumeroPagina();
            cantidadElementosPorPagina = dto.getPaginado().getCantidadElementos();
        }

        PanacheQuery<Entity_Persona> panacheResponse = repository
                .buscarPaginadoParametrosOpcionales(
                        rut,
                        dv,
                        nombre,
                        idPersonaLegacy,
                        paginaActual,
                        cantidadElementosPorPagina
                );

        PaginadoResponse salida = new PaginadoResponse();
        salida.setData(mapper.crearDTO(panacheResponse.list()));
        salida.setCantidadDePaginas(panacheResponse.pageCount());
        salida.setCantidadElementosEncontrados(panacheResponse.count());
        salida.setTienePaginaAnterior(panacheResponse.hasPreviousPage());
        salida.setTieneSiguientePagina(panacheResponse.hasNextPage());

        return salida;
    }

    private void logear(Object obj) {
        try {
            ObjectMapper mape = new ObjectMapper();
            log.info("----> " + mape.writeValueAsString(obj));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
