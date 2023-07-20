package cl.bicevida.Liquidador.application.rutas;


import cl.bicevida.Liquidador.application.controladores.Liquidador_CrearLiquidador_Controlador;
import cl.bicevida.Liquidador.application.controladores.Liquidador_EliminarLiquidador_Controlador;
import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.CrearLiquidador_PuertoSalida;
import cl.bicevida.Liquidador.domain.puertoSalida.EliminarLiquidador_PuertoSalida;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
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
    @Inject
    EliminarLiquidador_PuertoSalida eliminarLiquidadorPuertoSalida;


    @POST
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackCrearLiquidador")
    public Response crearLiquidador(Liquidador_Modelo data_liquidador) {
        Liquidador_CrearLiquidador_Controlador controlador = new Liquidador_CrearLiquidador_Controlador(crearLiquidadorPuertoSalida);
        return Response.status(201).entity(controlador.crearLiquidador_PuertoEntrada(data_liquidador)).build();
    }
    public Response fallbackCrearLiquidador(Liquidador_Modelo liquidador) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackEliminarPais")
    public Response eliminarLiquidador(@PathParam("id") Long id) {
        Liquidador_EliminarLiquidador_Controlador controlador = new Liquidador_EliminarLiquidador_Controlador(eliminarLiquidadorPuertoSalida);
        controlador.eliminarLiquidador_PuertoEntrada(id);
        return Response.status(201).build();
    }
    public Response fallbackEliminarPais(@PathParam("id") Long id) {
        return Response.status(503).build();
    }
}
