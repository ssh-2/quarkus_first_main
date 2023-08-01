package cl.bicevida.Banco.application.rutas;

import cl.bicevida.Banco.application.controladores.*;
import cl.bicevida.Banco.domain.DTO.Request_Save_DTO_Banco;
import cl.bicevida.Banco.domain.DTO.Request_Update_DTO_Banco;
import cl.bicevida.Banco.domain.puertoSalida.*;
import cl.bicevida.Utils.GeneralErrorResponse;
import cl.bicevida.Utils.GeneralStringResponse;
import cl.bicevida.Utils.ValidationErrorResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import jakarta.validation.Validator;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static cl.bicevida.Utils.Constants.REGISTRO_ELIMINADO;

@Path("/api/banco")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Rutas_Banco {

    @Inject
    Validator validator;


    @Inject
    PuertoSalida_BuscarTodos_Banco buscarTodos_PuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_Banco buscarPorID_PuertoSalida;
    @Inject
    PuertoSalida_Crear_Banco crear_PuertoSalida;
    @Inject
    PuertoSalida_Actualizar_Banco actualizar_PuertoSalida;
    @Inject
    PuertoSalida_Eliminar_Banco eliminar_PuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodos")
    public Response getAll() {
        Controller_BuscarTodos_Banco controlador = new Controller_BuscarTodos_Banco(buscarTodos_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.buscarTodos()).build();
    }
    public Response fallbackTodos() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackObtenerCanal")
    public Response getById(@PathParam("id") Long id) throws Exception {
        try {
            Controller_BuscarPorID_Banco controlador = new Controller_BuscarPorID_Banco(buscarPorID_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.buscarPorID(id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackObtenerCanal(@PathParam("id") Long id) {
        return Response.status(503).build();
    }


    @POST
    @Retry(maxRetries = 3, delay = 3000, abortOn = {ValidationException.class})
    @Fallback(fallbackMethod = "fallbackCrearProcesoEstado")
    public Response crear(Request_Save_DTO_Banco dto) {
        Set<ConstraintViolation<Request_Save_DTO_Banco>> violations = validator.validate(dto);
        if(!violations.isEmpty()) {
            List<String> error = new ArrayList<>();
            violations.forEach((x -> error.add(x.getMessage())));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(error)).build();
        }
        Controller_Crear_Banco controlador = new Controller_Crear_Banco(crear_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.crear(dto)).build();
    }

    public Response fallbackCrearProcesoEstado(Request_Save_DTO_Banco dto) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackActualizar")
    public Response actualizar(@PathParam("id") long id, Request_Update_DTO_Banco dto) {
        Set<ConstraintViolation<Request_Update_DTO_Banco>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            List<String> errors = new ArrayList<>();
            violations.forEach(x -> errors.add(x.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(errors)).build();
        }

        try {
            Controller_Actualizar_Banco controlador = new Controller_Actualizar_Banco(actualizar_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.actualizar(id, dto)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }

    }

    public Response fallbackActualizar(long id, Request_Update_DTO_Banco dto) {
        return Response.status(503).build();
    }


    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackEliminar")
    public Response delete(@PathParam("id") long id) {
        try {
            Controller_Eliminar_Banco controlador = new Controller_Eliminar_Banco(eliminar_PuertoSalida);
            controlador.eliminarPorID(id);
            return Response.status(Response.Status.OK).entity(new GeneralStringResponse(REGISTRO_ELIMINADO+id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackEliminar(long id) {
        return Response.status(503).build();
    }

}
