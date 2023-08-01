package cl.bicevida.HomologacionCoberturaLegacy.application.rutas;

import cl.bicevida.HomologacionCoberturaLegacy.application.controladores.*;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Save_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.DTO.Request_Update_DTO_HomologacionCoberturaLegacy;
import cl.bicevida.HomologacionCoberturaLegacy.domain.puertoSalida.*;
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
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import jakarta.validation.Validator;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static cl.bicevida.Utils.Constants.INTERNAL_SERVER_ERROR;
import static cl.bicevida.Utils.Constants.REGISTRO_ELIMINADO;

@Path("/api/homologacion-cobertura-legacy")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
@Slf4j
public class Rutas_HomologacionCoberturaLegacy {

    @Inject
    Validator validator;

    @Inject
    PuertoSalida_BuscarTodos_HomologacionCoberturaLegacy buscarTodos_PuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_HomologacionCoberturaLegacy buscarPorID_PuertoSalida;
    @Inject
    PuertoSalida_Crear_HomologacionCoberturaLegacy crear_PuertoSalida;
    @Inject
    PuertoSalida_Actualizar_HomologacionCoberturaLegacy actualizar_PuertoSalida;
    @Inject
    PuertoSalida_Eliminar_HomologacionCoberturaLegacy eliminar_PuertoSalida;

    @GET
    @Operation(summary = "Listado con todos los registros en la tabla", description = "Devuelve lista con todos los registros en la tabla, excepto campos con valor nulo")
    @APIResponses(value = {@APIResponse(responseCode = "200", description = "OK"), @APIResponse(responseCode = "400", description = "No encontrado")})
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackTodos")
    public Response getAll() {
        Controller_BuscarTodos_HomologacionCoberturaLegacy controlador = new Controller_BuscarTodos_HomologacionCoberturaLegacy(buscarTodos_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.buscarTodos()).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class, InternalServerErrorException.class})
    @Fallback(fallbackMethod = "fallbackObtener")
    public Response getById(@PathParam("id") long id) throws Exception {
        try {
            Controller_BuscarPorID_HomologacionCoberturaLegacy controlador = new Controller_BuscarPorID_HomologacionCoberturaLegacy(buscarPorID_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.buscarPorID(id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackObtener(long id) {
        return Response.status(503).build();
    }

    public Response fallbackTodos() {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000, abortOn = {ValidationException.class})
    @Fallback(fallbackMethod = "fallbackCrear")
    public Response crear(Request_Save_DTO_HomologacionCoberturaLegacy dto) {
        Set<ConstraintViolation<Request_Save_DTO_HomologacionCoberturaLegacy>> violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            List<String> errors = new ArrayList<>();
            violations.forEach(x -> errors.add(x.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(errors)).build();
        }
        Controller_Crear_HomologacionCoberturaLegacy controlador = new Controller_Crear_HomologacionCoberturaLegacy(crear_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.crear(dto)).build();
    }

    public Response fallbackCrear(Request_Save_DTO_HomologacionCoberturaLegacy dto) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {InternalServerErrorException.class, NotFoundException.class, ProcessingException.class, ValidationException.class, BadRequestException.class})
    @Fallback(fallbackMethod = "fallbackActualizar")
    public Response actualizar(@PathParam("id") long id, Request_Update_DTO_HomologacionCoberturaLegacy dto) {
        log.info("[PUT] - Se Realizo una llamada para modificar HomologacionCoberturaLegacy");

        try {
            Set<ConstraintViolation<Request_Update_DTO_HomologacionCoberturaLegacy>> violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                List<String> errors = new ArrayList<>();
                violations.forEach(x -> errors.add(x.getMessage()));
                return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(errors)).build();
            }

            Controller_Actualizar_HomologacionCoberturaLegacy controlador = new Controller_Actualizar_HomologacionCoberturaLegacy(actualizar_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.actualizar(id, dto)).build();
        } catch (BadRequestException | NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (InternalServerErrorException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new GeneralErrorResponse(INTERNAL_SERVER_ERROR)).build();
        }
    }

    public Response fallbackActualizar(long id, Request_Update_DTO_HomologacionCoberturaLegacy dto) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackEliminar")
    public Response delete(@PathParam("id") long id) {
        try {
            Controller_Eliminar_HomologacionCoberturaLegacy controlador = new Controller_Eliminar_HomologacionCoberturaLegacy(eliminar_PuertoSalida);
            controlador.eliminarPorID(id);
            return Response.status(Response.Status.OK).entity(new GeneralStringResponse(REGISTRO_ELIMINADO + id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackEliminar(long id) {
        return Response.status(503).build();
    }



}
