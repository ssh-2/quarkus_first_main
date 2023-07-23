package cl.bicevida.ProcesoEstado.infrastructure;

import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.ObtenerProcesoEstado_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesoEstado_ObtenerProcesoEstado_DB implements ObtenerProcesoEstado_PuertoSalida {

    @Inject
    ProcesoEstado_PanacheRepository repository;

    @Override
    public ProcesoEstado_Modelo obtenerProcesoEstado_PuertoSalida(Long id) {
        return repository.findById(id);
    }
}
