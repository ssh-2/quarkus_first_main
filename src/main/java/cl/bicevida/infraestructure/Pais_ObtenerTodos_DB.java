package cl.bicevida.infraestructure;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosSalida.ObtenerTodosPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;

@ApplicationScoped
public class Pais_ObtenerTodos_DB implements ObtenerTodosPais_PuertoSalida {

    @Inject
    Pais_PanacheRepository panacheRepository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public List<Pais_Modelo> obtenerTodosPais_PuertoSalida(){
        return panacheRepository.listAll();
    }
}
