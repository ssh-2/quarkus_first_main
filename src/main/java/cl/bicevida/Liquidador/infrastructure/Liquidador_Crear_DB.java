package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Crear_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Liquidador_Crear_DB implements PuertoSalida_Crear_Liquidador {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Entity_Liquidador crearLiquidador_PuertoSalida(Entity_Liquidador liquidador) {
        repository.persist(liquidador);
        return repository.findById(liquidador.getId()) ;
    }
}
