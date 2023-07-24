package cl.bicevida.Liquidador.application.rutas;


import cl.bicevida.Liquidador.application.controladores.*;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
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
public class Rutas_Liquidador {

    @Inject
    PuertoSalida_BuscarTodos_Liquidador obtenerTodosLiquidadorPuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_Liquidador obtenerLiquidadorPuertoSalida;
    @Inject
    PuertoSalida_Crear_Liquidador crearLiquidadorPuertoSalida;
    @Inject
    PuertoSalida_Actualizar_Liquidador actualizarLiquidadorPuertoSalida;
    @Inject
    PuertoSalida_Eliminar_Liquidador eliminarLiquidadorPuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodosLosLiquidadores")
    public Response todosLiquidadores() {
        Controller_BuscarTodos_Liquidador controlador = new Controller_BuscarTodos_Liquidador(obtenerTodosLiquidadorPuertoSalida);
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
        Controller_BuscarPorID_Liquidador controlador = new Controller_BuscarPorID_Liquidador(obtenerLiquidadorPuertoSalida);
        Entity_Liquidador liquidador_encontrado = controlador.obtenerLiquidador_PuertoEntrada(id);
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
    public Response crearLiquidador(Entity_Liquidador data_liquidador) {
        Controller_Crear_Liquidador controlador = new Controller_Crear_Liquidador(crearLiquidadorPuertoSalida);
        return Response.status(201).entity(controlador.crearLiquidador_PuertoEntrada(data_liquidador)).build();
    }
    public Response fallbackCrearLiquidador(Entity_Liquidador liquidador) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarLiquidador")
    public Response actualizarLiquidador(@PathParam("id")Long id, Entity_Liquidador liquidador) {
        Controller_Actualizar_Liquidador controlador = new Controller_Actualizar_Liquidador(actualizarLiquidadorPuertoSalida);
        return Response.status(201).entity(controlador.actualizarLiquidador_PuertoEntrada(id, liquidador)).build();
    }

    public Response fallbackActualizarLiquidador(Long id, Entity_Liquidador liquidador) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackEliminarPais")
    public Response eliminarLiquidador(@PathParam("id") Long id) {
        Controller_Eliminar_Liquidador controlador = new Controller_Eliminar_Liquidador(eliminarLiquidadorPuertoSalida);
        controlador.eliminarLiquidador_PuertoEntrada(id);
        return Response.status(201).build();
    }
    public Response fallbackEliminarPais(@PathParam("id") Long id) {
        return Response.status(503).build();
    }
}
