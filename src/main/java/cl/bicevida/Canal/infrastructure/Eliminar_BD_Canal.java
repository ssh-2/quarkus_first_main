package cl.bicevida.Canal.infrastructure;


import cl.bicevida.Canal.domain.puertoSalida.PuertoSalida_Eliminar_Canal;
import cl.bicevida.Canal.utils.Mapper_Canal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_Canal implements PuertoSalida_Eliminar_Canal {
    private final PanacheRepository_Canal repository;

    public Eliminar_BD_Canal(PanacheRepository_Canal repository) {
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
