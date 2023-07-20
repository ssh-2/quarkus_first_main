package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.CrearLiquidador_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Liquidador_Crear_DB implements CrearLiquidador_PuertoSalida {

    @Inject
    Liquidador_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Liquidador_Modelo crearLiquidador_PuertoSalida(Liquidador_Modelo liquidador) {
        return repository.findById(liquidador.id) ;
    }
}
