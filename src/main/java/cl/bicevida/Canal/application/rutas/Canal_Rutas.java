package cl.bicevida.Canal.application.rutas;

import cl.bicevida.Canal.application.controladores.*;
import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoSalida.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api/canal")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Canal_Rutas {

    @Inject
    ObtenerTodosCanal_PuertoSalida todosCanalPuertoSalida;
    @Inject
    ObtenerCanal_PuertoSalida obtenerCanalPuertoSalida;
    @Inject
    CrearCanal_PuertoSalida crearCanalPuertoSalida;
    @Inject
    ActualizarCanal_PuertoSalida actualizarCanalPuertoSalida;
    @Inject
    EliminarCanal_PuertoSalida eliminarCanalPuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodosLosCanales")
    public Response todosLosCanales() {
        Canal_ObtenerTodosCanal_Controlador controlador = new Canal_ObtenerTodosCanal_Controlador(todosCanalPuertoSalida);
        return Response.status(200).entity(controlador.obtenerTodosCanal_PuertoEntrada()).build();
    }
    public Response fallbackTodosLosCanales() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerCanal")
    public Response obtenerCanal(@PathParam("id") Long id) {
        Canal_ObtenerCanal_Controlador controlador = new Canal_ObtenerCanal_Controlador(obtenerCanalPuertoSalida);
        Canal_Modelo canal_encontrado = controlador.obtenerCanal_PuertoEntrada(id);
        if(canal_encontrado != null) {
            return Response.status(200).entity(canal_encontrado).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    public Response fallbackObtenerCanal(@PathParam("id") Long id) {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackCrearCanal")
    public Response crearCanal(Canal_Modelo data_canal) {
        Canal_CrearCanal_Controlador controlador = new Canal_CrearCanal_Controlador(crearCanalPuertoSalida);
        return Response.status(201).entity(controlador.crearCanala_PuertoEntrada(data_canal)).build();
    }

    public Response fallbackCrearCanal(Canal_Modelo canal) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarCanal")
    public Response actualizarCanal(@PathParam("id") Long id, Canal_Modelo canal) {
        Canal_ActualizarCanal_Controlador controlador = new Canal_ActualizarCanal_Controlador(actualizarCanalPuertoSalida);
        return Response.status(201).entity(controlador.actualizarCanal_PuertoEntrada(id, canal)).build();
    }

    public Response fallbackActualizarCanal(Long id, Canal_Modelo canal) {
        return  Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackElimninarCanal")
    public Response eliminarCanal(@PathParam("id")Long id) {
        Canal_EliminarCanal_Controlador controlador = new Canal_EliminarCanal_Controlador(eliminarCanalPuertoSalida);
        controlador.eliminarCanal_PuertoEntrada(id);
        return Response.status(201).build();
    }

    public Response fallbackElimninarCanal(Long id) {
        return Response.status(503).build();
    }
}
