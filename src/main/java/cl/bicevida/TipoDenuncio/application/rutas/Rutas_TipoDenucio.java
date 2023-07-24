package cl.bicevida.TipoDenuncio.application.rutas;


import cl.bicevida.TipoDenuncio.application.controladores.*;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
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
public class Rutas_TipoDenucio {

    @Inject
    PuertoSalida_BuscarTodos_TipoDenucio obtenerTodosTipoDenucioPuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_TipoDenucio obtenerTipoDenucioPuertoSalida;
    @Inject
    PuertoSalida_Crear_TipoDenucio crearTipoDenucioPuertoSalida;
    @Inject
    PuertoSalida_Actualizar_TipoDenucio actualizarTipoDenucioPuertoSalida;
    @Inject
    PuertoSalida_Eliminar_TipoDenucio eliminarTipoDenucioPuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerTodosTipoDenucio")
    public Response obtenerTodosTipoDenucio() {
        Controller_BuscarTodos_TipoDenucio controlador = new Controller_BuscarTodos_TipoDenucio(obtenerTodosTipoDenucioPuertoSalida);
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
        Controller_BuscarPorID_TipoDenucio controlador = new Controller_BuscarPorID_TipoDenucio(obtenerTipoDenucioPuertoSalida);
        Entity_TipoDenucio tipoDenucio_encontrado = controlador.obtenerTipoDenucio_PuertoEntrada(id);
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
    public Response crearTipoDenucio(Entity_TipoDenucio data_tipoDenucio) {
        Controller_Crear_TipoDenucio controlador = new Controller_Crear_TipoDenucio(crearTipoDenucioPuertoSalida);
        return Response.status(201).entity(controlador.crearTipoDenucio_PuertoEntrada(data_tipoDenucio)).build();
    }

    public Response fallbackCrearTipoDenucio(Entity_TipoDenucio tipoDenucio) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarTipoDenucio")
    public Response actualizarTipoDenucio(@PathParam("id") Long id, Entity_TipoDenucio tipoDenucio) {
        Controller_Actualizar_TipoDenucio controlador = new Controller_Actualizar_TipoDenucio(actualizarTipoDenucioPuertoSalida);
        return Response.status(201).entity(controlador.actualizarTipoDenucio_PuertoEntrada(id, tipoDenucio)).build();
    }

    public Response fallbackActualizarTipoDenucio(Long id, Entity_TipoDenucio tipoDenucio) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackEliminarTipoDenucio")
    public Response eliminarTipoDenuci(@PathParam("id") Long id) {
        Controller_Eliminar_TipoDenucio controlador = new Controller_Eliminar_TipoDenucio(eliminarTipoDenucioPuertoSalida);
        controlador.eliminarTipoDenucio_PuertoEntrada(id);
        return Response.status(201).build();
    }

    public Response fallbackEliminarTipoDenucio(Long id) {
        return Response.status(503).build();
    }
}
