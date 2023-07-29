package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Eliminar_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_TipoCuentaBanco implements PuertoSalida_Eliminar_TipoCuentaBanco {

    private final PanacheRepository_TipoCuentaBanco repository;

    public Eliminar_BD_TipoCuentaBanco(PanacheRepository_TipoCuentaBanco repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void eliminarPorID(Long id) {
        try{
            log.info("[DELETE] eliminado por id: " + id);
            repository.findByIdOptional(id)
                    .orElseThrow(()-> new NotFoundException(NOT_FOUND_BY_ID+id));

            repository.deleteById(id);
        } catch (NotFoundException e) {
            log.error(ERROR_CLASS + e.getClass());
            log.error(ERROR_MSG + e.getMessage());
            throw new NotFoundException(e.getMessage());
        }

    }
}
