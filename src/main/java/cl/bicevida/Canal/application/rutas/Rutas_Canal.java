package cl.bicevida.Canal.application.rutas;

import cl.bicevida.Canal.application.controladores.*;
import cl.bicevida.Canal.domain.DTO.Request_Save_DTO_Canal;
import cl.bicevida.Canal.domain.DTO.Request_Update_DTO_Canal;
import cl.bicevida.Canal.domain.puertoSalida.*;
import cl.bicevida.Utils.GeneralErrorResponse;
import cl.bicevida.Utils.GeneralStringResponse;
import cl.bicevida.Utils.ValidationErrorResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static cl.bicevida.Utils.Constants.INTERNAL_SERVER_ERROR;
import static cl.bicevida.Utils.Constants.REGISTRO_ELIMINADO;

@Path("/api/canal")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Rutas_Canal {

    @Inject
    Validator validator;

    @Inject
    PuertoSalida_BuscarTodos_Canal buscarTodos_PuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_Canal buscarPorId_PuertoSalida;
    @Inject
    PuertoSalida_Crear_Canal crear_PuertoSalida;
    @Inject
    PuertoSalida_Actualizar_Canal actualizarCanalPuertoSalida;
    @Inject
    PuertoSalida_Eliminar_Canal eliminar_PuertoSalida;

    @GET
    @APIResponses(
            value = {@APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodos")
    public Response getAll() {
        Controller_BuscarTodos_Canal controlador = new Controller_BuscarTodos_Canal(buscarTodos_PuertoSalida);
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
            Controller_BuscarPorID_Canal controlador = new Controller_BuscarPorID_Canal(buscarPorId_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.buscarPorID_PuertoEntrada(id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackObtenerCanal(@PathParam("id") Long id) {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000, abortOn = {ValidationException.class})
    @Fallback(fallbackMethod = "fallbackCrearCanal")
    public Response crear(Request_Save_DTO_Canal dto) {
        try {
            Set<ConstraintViolation<Request_Save_DTO_Canal>> violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                List<String> error = new ArrayList<>();
                violations.forEach((x -> error.add(x.getMessage())));
                return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(error)).build();
            }
            Controller_Crear_Canal controlador = new Controller_Crear_Canal(crear_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.crear(dto)).build();
        } catch (BadRequestException | NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (org.jboss.resteasy.spi.InternalServerErrorException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new GeneralErrorResponse(INTERNAL_SERVER_ERROR)).build();
        }
    }

    public Response fallbackCrearCanal(Request_Save_DTO_Canal dto) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackActualizarCanal")
    public Response actualizar(@PathParam("id") Long id, Request_Update_DTO_Canal dto) {
        try {
            Set<ConstraintViolation<Request_Update_DTO_Canal>> violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                List<String> errors = new ArrayList<>();
                violations.forEach(x -> errors.add(x.getMessage()));
                return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(errors)).build();
            }
            Controller_Actualizar_Canal controlador = new Controller_Actualizar_Canal(actualizarCanalPuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.actualizar(id, dto)).build();
        } catch (BadRequestException | NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (org.jboss.resteasy.spi.InternalServerErrorException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new GeneralErrorResponse(INTERNAL_SERVER_ERROR)).build();
        }
    }

    public Response fallbackActualizarCanal(Long id, Request_Update_DTO_Canal dto) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackElimninarCanal")
    public Response eliminarCanal(@PathParam("id") Long id) {
        try {
            Controller_Eliminar_Canal controlador = new Controller_Eliminar_Canal(eliminar_PuertoSalida);
            controlador.eliminarPorID(id);
            return Response.status(Response.Status.OK).entity(new GeneralStringResponse(REGISTRO_ELIMINADO)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackElimninarCanal(Long id) {
        return Response.status(503).build();
    }
}
