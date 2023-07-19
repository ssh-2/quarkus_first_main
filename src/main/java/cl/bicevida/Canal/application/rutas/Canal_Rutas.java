package cl.bicevida.Canal.application.rutas;

import cl.bicevida.Canal.application.controladores.Canal_ActualizarCanal_Controlador;
import cl.bicevida.Canal.application.controladores.Canal_CrearCanal_Controlador;
import cl.bicevida.Canal.application.controladores.Canal_EliminarCanal_Controlador;
import cl.bicevida.Canal.domain.modelo.Canal_Modelo;
import cl.bicevida.Canal.domain.puertoSalida.ActualizarCanal_PuertoSalida;
import cl.bicevida.Canal.domain.puertoSalida.CrearCanal_PuertoSalida;
import cl.bicevida.Canal.domain.puertoSalida.EliminarCanal_PuertoSalida;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;


@Path("/api/canal")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Canal_Rutas {

    @Inject
    CrearCanal_PuertoSalida crearCanalPuertoSalida;
    @Inject
    ActualizarCanal_PuertoSalida actualizarCanalPuertoSalida;
    @Inject
    EliminarCanal_PuertoSalida eliminarCanalPuertoSalida;



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
    @Fallback(fallbackMethod = "fallbackElimnarCanal")
    public Response eliminarCanal(@PathParam("id")Long id) {
        Canal_EliminarCanal_Controlador controlador = new Canal_EliminarCanal_Controlador(eliminarCanalPuertoSalida);
        controlador.eliminarCanal_PuertoEntrada(id);
        return Response.status(201).build();
    }

    public Response fallbackElimnarCanal(Long id) {
        return Response.status(503).build();
    }
}
