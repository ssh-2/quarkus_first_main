package cl.bicevida.ProcesoEstado.application.rutas;

import cl.bicevida.ProcesoEstado.application.controladores.*;
import cl.bicevida.ProcesoEstado.domain.modelo.Entity_ProcesoEstado;
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
public class Rutas_ProcesoEstado {


    @Inject
    PuertoSalida_BuscarTodos_ProcesoEstado obtenerTodosProcesoEstadoPuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_ProcesoEstado obtenerProcesoEstadoPuertoSalida;
    @Inject
    PuertoSalida_Crear_ProcesoEstado crearProcesoEstadoPuertoSalida;
    @Inject
    PuertoSalida_Actualizar_ProcesoEstado actualizarProcesoEstadoPuertoSalida;
    @Inject
    PuertoSalida_Eliminar_ProcesoEstado eliminarProcesoEstadoPuertoSalida;


    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodosLosProcesoEstado")
    public Response todosLosProcesoEstados() {
        Controller_BuscarTodos_ProcesoEstado controlador = new Controller_BuscarTodos_ProcesoEstado(obtenerTodosProcesoEstadoPuertoSalida);
        return Response.status(201).entity(controlador.obtenerTodosProcesoEstado_PuertoEntrada()).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerProcesoEstado")
    public Response obtnerProcesoEstado(@PathParam("id") Long id) {
        Controller_BuscarPorID_ProcesoEstado controlador = new Controller_BuscarPorID_ProcesoEstado(obtenerProcesoEstadoPuertoSalida);
        Entity_ProcesoEstado procesoEstado_encontrado = controlador.obtenerProcesoEstado_PuertoEntrada(id);
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
    public Response crearProcesoEstado(Entity_ProcesoEstado data_procesoEstado) {
        Controller_Crear_ProcesoEstado controlador = new Controller_Crear_ProcesoEstado(crearProcesoEstadoPuertoSalida);
        return Response.status(201).entity(controlador.crearProcesoEstado_PuertoEntrada(data_procesoEstado)).build();
    }

    public Response fallbackCrearProcesoEstado(Entity_ProcesoEstado procesoEstado) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarProcesoEstado")
    public Response actualizarProcesoEstado(@PathParam("id") Long id, Entity_ProcesoEstado procesoEstado) {
        Controller_Acutalizar_ProcesoEstado controlador = new Controller_Acutalizar_ProcesoEstado(actualizarProcesoEstadoPuertoSalida);
        return Response.status(201).entity(controlador.actualizarProcesoEstado_PuertoEntrada(id, procesoEstado)).build();
    }

    public Response fallbackActualizarProcesoEstado(Long id, Entity_ProcesoEstado procesoEstado) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackEliminarProcesoEstado")
    public Response eliminarProcesoEstado(@PathParam("id") Long id) {
        Controller_Eliminar_ProcesoEstado controlador = new Controller_Eliminar_ProcesoEstado(eliminarProcesoEstadoPuertoSalida);
        controlador.eliminarProcesoEstado_PuertoEntrada(id);
        return Response.status(201).build();
    }

    public Response fallbackEliminarProcesoEstado(Long id) {
        return Response.status(503).build();
    }
}
