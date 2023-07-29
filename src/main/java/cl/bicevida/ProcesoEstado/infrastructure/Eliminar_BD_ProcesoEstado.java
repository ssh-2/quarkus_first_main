package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.puertaSalida.PuertoSalida_Eliminar_ProcesoEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_ProcesoEstado implements PuertoSalida_Eliminar_ProcesoEstado {

    private final PanacheRepository_ProcesoEstado repository;

    public Eliminar_BD_ProcesoEstado(PanacheRepository_ProcesoEstado repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void eliminarPorID(Long id) {
        try {
            log.info("[DELETE] eliminado por id " + id);
            repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));
            repository.deleteById(id);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getMessage());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }
    }
}
