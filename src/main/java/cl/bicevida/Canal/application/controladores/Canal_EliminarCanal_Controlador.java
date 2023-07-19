package cl.bicevida.Canal.application.controladores;


import cl.bicevida.Canal.domain.puertoEntrada.EliminarCanal_PuertoEntrada;
import cl.bicevida.Canal.domain.puertoSalida.EliminarCanal_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Canal_EliminarCanal_Controlador implements EliminarCanal_PuertoEntrada {

    private EliminarCanal_PuertoSalida eliminarCanalPuertoSalida;

    public Canal_EliminarCanal_Controlador(EliminarCanal_PuertoSalida eliminarCanalPuertoSalida) {
        this.eliminarCanalPuertoSalida = eliminarCanalPuertoSalida;
    }

    @Override
    public void eliminarCanal_PuertoEntrada(Long id) {
        eliminarCanalPuertoSalida.eliminarCanalPuertoSalida(id);
    }
}
