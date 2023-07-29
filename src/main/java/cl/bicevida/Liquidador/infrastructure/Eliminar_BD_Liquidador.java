package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Eliminar_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_Liquidador implements PuertoSalida_Eliminar_Liquidador {

    private final PanacheRepository_Liquidador repository;

    public Eliminar_BD_Liquidador(PanacheRepository_Liquidador repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void eliminarPorID(Long id) {
        try {
            log.info("[DELETE] eliminando por id " + id);
            repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID + id));
            repository.deleteById(id);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }

    }
}
