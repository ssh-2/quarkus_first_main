package cl.bicevida.infraestructure;

import cl.bicevida.domain.modelo.Pais_Modelo;
import cl.bicevida.domain.puertosSalida.ActualizarPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.LocalDateTime;

@ApplicationScoped
public class Pais_ActualizarPais_DB implements ActualizarPais_PuertoSalida {

    @Inject
    Pais_PanacheRepository repository;

    @Override
    @Retry(maxRetries = 3, delay = 3000)
    @Transactional
    public Pais_Modelo actualizarPais_PuertoSalida(long id, Pais_Modelo data_pais) {
        Pais_Modelo pais_actual = repository.findById(id);
        pais_actual.nombre = data_pais.nombre;
        pais_actual.crmNombre = data_pais.crmNombre;
        pais_actual.ctNombre = data_pais.ctNombre;
        pais_actual.sysAccion = data_pais.sysAccion;
        pais_actual.sysAplicacion = data_pais.sysAplicacion;
        pais_actual.sysEliminado = data_pais.sysEliminado;
        pais_actual.sysFechaMoficiacion = LocalDateTime.now();
        pais_actual.sysId = data_pais.sysId;
        pais_actual.sysTipo = data_pais.sysTipo;
        pais_actual.sysUsuario = data_pais.sysUsuario;
        pais_actual.sysVersion = data_pais.sysVersion;
        repository.persist(pais_actual);
        return repository.findById(pais_actual.codigoPais);
    }
}
