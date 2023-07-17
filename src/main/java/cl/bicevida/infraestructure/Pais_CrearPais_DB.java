package cl.bicevida.infraestructure;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosSalida.CrearPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.LocalDateTime;

@ApplicationScoped
public class Pais_CrearPais_DB implements CrearPais_PuertoSalida {

    @Inject
    Pais_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Pais_Modelo crearPais_PuertoSalida(Pais_Modelo pais){
        pais.sysFechaMoficiacion = LocalDateTime.now();
        repository.persist(pais);
        return repository.findById(pais.codigoPais);
    }
}
