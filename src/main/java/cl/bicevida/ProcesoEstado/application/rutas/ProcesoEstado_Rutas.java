package cl.bicevida.ProcesoEstado.application.rutas;

import cl.bicevida.ProcesoEstado.application.controladores.*;
import cl.bicevida.ProcesoEstado.domain.modelo.ProcesoEstado_Modelo;
import cl.bicevida.ProcesoEstado.domain.puertaSalida.*;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api/procesoestado")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class ProcesoEstado_Rutas {


    @Inject
    ObtenerTodosProcesoEstado_PuertoSalida obtenerTodosProcesoEstadoPuertoSalida;
    @Inject
    ObtenerProcesoEstado_PuertoSalida obtenerProcesoEstadoPuertoSalida;
    @Inject
    CrearProcesoEstado_PuertoSalida crearProcesoEstadoPuertoSalida;
    @Inject
    ActualizarProcesoEstado_PuertoSalida actualizarProcesoEstadoPuertoSalida;
    @Inject
    EliminarProcesoEstado_PuertoSalida eliminarProcesoEstadoPuertoSalida;


    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodosLosProcesoEstado")
    public Response todosLosProcesoEstados() {
        ProcesoEstado_ObtenerTodos_Controlador controlador = new ProcesoEstado_ObtenerTodos_Controlador(obtenerTodosProcesoEstadoPuertoSalida);
        return Response.status(201).entity(controlador.obtenerTodosProcesoEstado_PuertoEntrada()).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerProcesoEstado")
    public Response obtnerProcesoEstado(@PathParam("id") Long id) {
        ProcesoEstado_ObtenerProcesoEstado_Controlador controlador = new ProcesoEstado_ObtenerProcesoEstado_Controlador(obtenerProcesoEstadoPuertoSalida);
        ProcesoEstado_Modelo procesoEstado_encontrado = controlador.obtenerProcesoEstado_PuertoEntrada(id);
        if(procesoEstado_encontrado != null) {
            return Response.status(201).entity(procesoEstado_encontrado).build();
        }
        else {
            return Response.status(404).build();
        }
    }

    public Response fallbackObtenerProcesoEstado(@PathParam("id") Long id) {
        return Response.status(503).build();
    }

    public Response fallbackTodosLosProcesoEstado() {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackCrearProcesoEstado")
    public Response crearProcesoEstado(ProcesoEstado_Modelo data_procesoEstado) {
        ProcesoEstado_CrearProcesoEstado_Controlador controlador = new ProcesoEstado_CrearProcesoEstado_Controlador(crearProcesoEstadoPuertoSalida);
        return Response.status(201).entity(controlador.crearProcesoEstado_PuertoEntrada(data_procesoEstado)).build();
    }

    public Response fallbackCrearProcesoEstado(ProcesoEstado_Modelo procesoEstado) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarProcesoEstado")
    public Response actualizarProcesoEstado(@PathParam("id") Long id, ProcesoEstado_Modelo procesoEstado) {
        ProcesoEstado_ActualizarEstado_Controlador controlador = new ProcesoEstado_ActualizarEstado_Controlador(actualizarProcesoEstadoPuertoSalida);
        return Response.status(201).entity(controlador.actualizarProcesoEstado_PuertoEntrada(id, procesoEstado)).build();
    }

    public Response fallbackActualizarProcesoEstado(Long id, ProcesoEstado_Modelo procesoEstado) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackEliminarProcesoEstado")
    public Response eliminarProcesoEstado(@PathParam("id") Long id) {
        ProcesoEstado_EliminarProcesoEstado_Controlador controlador = new ProcesoEstado_EliminarProcesoEstado_Controlador(eliminarProcesoEstadoPuertoSalida);
        controlador.eliminarProcesoEstado_PuertoEntrada(id);
        return Response.status(201).build();
    }

    public Response fallbackEliminarProcesoEstado(Long id) {
        return Response.status(503).build();
    }
}
