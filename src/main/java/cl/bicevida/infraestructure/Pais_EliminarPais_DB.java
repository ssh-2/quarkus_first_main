package cl.bicevida.infraestructure;

import cl.bicevida.domain.puertosSalida.EliminarPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Pais_EliminarPais_DB implements EliminarPais_PuertoSalida {

    @Inject
    Pais_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public void eliminarPais_PuertoSalida(long id){
        repository.deleteById(id);
    }
}
