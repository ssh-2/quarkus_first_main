package cl.bicevida.application.rutas;

import cl.bicevida.application.controladores.Persona_CrearPersona_Controlador;
import cl.bicevida.domain.modelo.Persona_Modelo;
import cl.bicevida.domain.puertosSalida.CrearPersona_PuertoSalida;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/api/template-base/persona")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)

public class Persona_Rutas {

    @Inject
    CrearPersona_PuertoSalida crearPersona_puertoSalida;

    @GET
    @Operation(
            summary = "Listado con todos los registros en la tabla",
            description = "Devuelve lista con todos los registros en la tabla, excepto campos con valor nulo"
    )
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )

    @POST
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackCrearPersona")
    public Response crearPersona(Persona_Modelo data_persona) {
        Persona_CrearPersona_Controlador controlador = new Persona_CrearPersona_Controlador(crearPersona_puertoSalida);
        return Response.status(201).entity(controlador.crearPersona_PuertoEntrada(data_persona)).build();
    }

    public Response fallbackCrearPersona(Persona_Modelo persona) {
        return Response.status(503).build();
    }
}
