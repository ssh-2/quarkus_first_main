package cl.bicevida.infraestructure;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosSalida.ObtenerPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Pais_ObtenerPais_DB implements ObtenerPais_PuertoSalida {

    @Inject
    Pais_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Pais_Modelo obtenerPais_PuertoSalida(long id){
        return repository.findById(id);
    }
}
