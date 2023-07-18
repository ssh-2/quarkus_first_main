package cl.bicevida.application.controladores;

import cl.bicevida.domain.puertosEntrada.EliminarPais_PuertoEntrada;
import cl.bicevida.domain.puertosSalida.EliminarPais_PuertoSalida;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Pais_EliminarPais_Controlador implements EliminarPais_PuertoEntrada {

    private EliminarPais_PuertoSalida eliminarPais_puertoSalida;

    public Pais_EliminarPais_Controlador(EliminarPais_PuertoSalida eliminarPais_puertoSalida) {
        this.eliminarPais_puertoSalida = eliminarPais_puertoSalida;
    }

    @Override
    public void eliminarPais_PuertoEntrada(long id){
        eliminarPais_puertoSalida.eliminarPais_PuertoSalida(id);
    }
}
