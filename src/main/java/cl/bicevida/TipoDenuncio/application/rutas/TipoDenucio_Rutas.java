package cl.bicevida.TipoDenuncio.application.rutas;


import cl.bicevida.TipoDenuncio.application.controladores.*;
import cl.bicevida.TipoDenuncio.domain.modelo.TipoDenuncio_Modelo;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api/tipoDenucio")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class TipoDenucio_Rutas {

    @Inject
    ObtenerTodosTipoDenucio_PuertoSalida obtenerTodosTipoDenucioPuertoSalida;
    @Inject
    ObtenerTipoDenucio_PuertoSalida obtenerTipoDenucioPuertoSalida;
    @Inject
    CrearTipoDenucio_PuertoSalida crearTipoDenucioPuertoSalida;
    @Inject
    ActualizarTipoDenucio_PuertoSalida actualizarTipoDenucioPuertoSalida;
    @Inject
    EliminarTipoDenucio_PuertoSalida eliminarTipoDenucioPuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerTodosTipoDenucio")
    public Response obtenerTodosTipoDenucio() {
        TipoDenucio_ObtenerTodos_Controlador controlador = new TipoDenucio_ObtenerTodos_Controlador(obtenerTodosTipoDenucioPuertoSalida);
        return Response.status(201).entity(controlador.obtenerTodosTipoDenucio_PuertoEntrada()).build();
    }

    public Response fallbackObtenerTodosTipoDenucio() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerTipoDenucio")
    public Response obtenerTipoDenucio(@PathParam("id") Long id) {
        TipoDenucio_ObtenerTipoDenucio_Controlador controlador = new TipoDenucio_ObtenerTipoDenucio_Controlador(obtenerTipoDenucioPuertoSalida);
        TipoDenuncio_Modelo tipoDenucio_encontrado = controlador.obtenerTipoDenucio_PuertoEntrada(id);
        if(tipoDenucio_encontrado != null) {
            return Response.status(201).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    public Response fallbackObtenerTipoDenucio(@PathParam("id") Long id) {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackCrearTipoDenucio")
    public Response crearTipoDenucio(TipoDenuncio_Modelo data_tipoDenucio) {
        TipoDenucio_CrearTipoDenucio_Controlador controlador = new TipoDenucio_CrearTipoDenucio_Controlador(crearTipoDenucioPuertoSalida);
        return Response.status(201).entity(controlador.crearTipoDenucio_PuertoEntrada(data_tipoDenucio)).build();
    }

    public Response fallbackCrearTipoDenucio(TipoDenuncio_Modelo tipoDenucio) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarTipoDenucio")
    public Response actualizarTipoDenucio(@PathParam("id") Long id, TipoDenuncio_Modelo tipoDenucio) {
        TipoDenucio_ActualizarTipoDenucio_Controlador controlador = new TipoDenucio_ActualizarTipoDenucio_Controlador(actualizarTipoDenucioPuertoSalida);
        return Response.status(201).entity(controlador.actualizarTipoDenucio_PuertoEntrada(id, tipoDenucio)).build();
    }

    public Response fallbackActualizarTipoDenucio(Long id, TipoDenuncio_Modelo tipoDenucio) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackEliminarTipoDenucio")
    public Response eliminarTipoDenuci(@PathParam("id") Long id) {
        TipoDenucio_EliminarTipoDenucio_Controlador controlador = new TipoDenucio_EliminarTipoDenucio_Controlador(eliminarTipoDenucioPuertoSalida);
        controlador.eliminarTipoDenucio_PuertoEntrada(id);
        return Response.status(201).build();
    }

    public Response fallbackEliminarTipoDenucio(Long id) {
        return Response.status(503).build();
    }
}
