package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.CrearProcesoEstado_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesoEstado_Crear_DB implements CrearProcesoEstado_PuertoSalida {

    @Inject
    ProcesoEstado_PanacheRepository repository;

    @Override
    public ProcesoEstado_Modelo crearProcesoEstado_PuertoSalida(ProcesoEstado_Modelo procesoEstado) {
        repository.persist(procesoEstado);
        return repository.findById(procesoEstado.getId());
    }
}
