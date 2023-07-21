package cl.bicevida.Liquidador.application.rutas;


import cl.bicevida.Liquidador.application.controladores.*;
import cl.bicevida.Liquidador.domain.modelo.Liquidador_Modelo;
import cl.bicevida.Liquidador.domain.puertoSalida.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api/liquidador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Liquidador_Rutas {

    @Inject
    ObtenerTodos_Liquidador_PuertoSalida obtenerTodosLiquidadorPuertoSalida;
    @Inject
    ObtenerLiquidador_PuertoSalida obtenerLiquidadorPuertoSalida;
    @Inject
    CrearLiquidador_PuertoSalida crearLiquidadorPuertoSalida;
    @Inject
    ActualizarLiquidador_PuertoSalida actualizarLiquidadorPuertoSalida;
    @Inject
    EliminarLiquidador_PuertoSalida eliminarLiquidadorPuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodosLosLiquidadores")
    public Response todosLiquidadores() {
        Liquidador_ObtenerTodos_Controlador controlador = new Liquidador_ObtenerTodos_Controlador(obtenerTodosLiquidadorPuertoSalida);
        return Response.status(201).entity(controlador.obtenerTodos_PuertaEntrada()).build();
    }

    public Response fallbackTodosLosLiquidadores() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerLiquidador")
    public Response obtenerLiquidador(@PathParam("id") Long id) {
        Liquidador_ObtenerLiquidador_Controlador controlador = new Liquidador_ObtenerLiquidador_Controlador(obtenerLiquidadorPuertoSalida);
        Liquidador_Modelo liquidador_encontrado = controlador.obtenerLiquidador_PuertoEntrada(id);
        if(liquidador_encontrado != null) {
            return Response.status(201).entity(liquidador_encontrado).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    public Response fallbackObtenerLiquidador(@PathParam("id") Long id) {
        return Response.status(503).build();
    }
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

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarLiquidador")
    public Response actualizarLiquidador(@PathParam("id")Long id, Liquidador_Modelo liquidador) {
        Liquidador_ActualizarLiquidador_Controlador controlador = new Liquidador_ActualizarLiquidador_Controlador(actualizarLiquidadorPuertoSalida);
        return Response.status(201).entity(controlador.actualizarLiquidador_PuertoEntrada(id, liquidador)).build();
    }

    public Response fallbackActualizarLiquidador(Long id, Liquidador_Modelo liquidador) {
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
