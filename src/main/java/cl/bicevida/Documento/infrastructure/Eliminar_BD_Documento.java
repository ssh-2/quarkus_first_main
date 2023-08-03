package cl.bicevida.Documento.infrastructure;

import cl.bicevida.Documento.domain.puertoEntrada.PuertoEntrada_Eliminar_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_Eliminar_Documento;
import cl.bicevida.Documento.utils.Mapper_Documento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import static cl.bicevida.Utils.Constants.*;

@ApplicationScoped
@Slf4j
public class Eliminar_BD_Documento implements PuertoSalida_Eliminar_Documento {

    private final PanacheRepository_Documento repository;

    public Eliminar_BD_Documento(PanacheRepository_Documento repository) {
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
