package cl.bicevida.Documento.application.controladores;

import cl.bicevida.Documento.domain.puertoEntrada.PuertoEntrada_Eliminar_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_Eliminar_Documento;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Controller_Eliminar_Documento implements PuertoEntrada_Eliminar_Documento {

    private final PuertoSalida_Eliminar_Documento puertoSalida;

    public Controller_Eliminar_Documento(PuertoSalida_Eliminar_Documento puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public void eliminarPorID(Long id) {
        puertoSalida.eliminarPorID(id);
    }
}
