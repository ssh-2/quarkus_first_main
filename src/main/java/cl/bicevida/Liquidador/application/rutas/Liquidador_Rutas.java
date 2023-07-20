package cl.bicevida.Liquidador.application.rutas;


import cl.bicevida.Liquidador.application.controladores.Liquidador_CrearLiquidador_Controlador;
import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.CrearLiquidador_PuertoSalida;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

@Path("/api/liquidador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Liquidador_Rutas {

    @Inject
    CrearLiquidador_PuertoSalida crearLiquidadorPuertoSalida;

    @POST
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackCrearLiquidador")
    public Response crearLiquidador(Liquidador_Modelo data_liquidador) {
        Liquidador_CrearLiquidador_Controlador controlador =new Liquidador_CrearLiquidador_Controlador(crearLiquidadorPuertoSalida);
        return Response.status(201).entity(controlador.crearLiquidador_PuertoEntrada(data_liquidador)).build();
    }

    public Response fallbackCrearLiquidador(Liquidador_Modelo liquidador) {
        return Response.status(503).build();
    }

}
