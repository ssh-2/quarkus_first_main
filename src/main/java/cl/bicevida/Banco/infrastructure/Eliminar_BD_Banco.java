package cl.bicevida.Banco.infrastructure;

import cl.bicevida.Banco.domain.puertoSalida.PuertoSalida_Eliminar_Banco;
import cl.bicevida.Banco.utils.Mapper_Banco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_Banco implements PuertoSalida_Eliminar_Banco {

    private final PanacheRepository_Banco repository;

    public Eliminar_BD_Banco(PanacheRepository_Banco repository, Mapper_Banco mapper) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void eliminarPorID(Long id) {

        try {
            log.info("[DELETE] eliminado por id: " + id);
            repository.findByIdOptional(id)
                    .orElseThrow(() -> new NotFoundException(NOT_FOUND_BY_ID + id));

            repository.deleteById(id);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }

    }

}
