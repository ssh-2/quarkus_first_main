package cl.bicevida.TipoDenuncio.application.rutas;


import cl.bicevida.Canal.application.controladores.Controller_BuscarPorID_Canal;
import cl.bicevida.TipoDenuncio.application.controladores.*;
import cl.bicevida.TipoDenuncio.domain.DTO.Request_Save_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.DTO.Request_Update_DTO_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.modelo.Entity_TipoDenucio;
import cl.bicevida.TipoDenuncio.domain.puertoSalida.*;
import cl.bicevida.Utils.GeneralErrorResponse;
import cl.bicevida.Utils.GeneralStringResponse;
import cl.bicevida.Utils.ValidationErrorResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.ValidationException;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static cl.bicevida.Utils.Constants.REGISTRO_ELIMINADO;

@Path("/api/tipoDenucio")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Rutas_TipoDenucio {

    @Inject
    Validator validator;

    @Inject
    PuertoSalida_BuscarTodos_TipoDenucio buscarTodos_PuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_TipoDenucio buscarPorID_PuertoSalida;
    @Inject
    PuertoSalida_Crear_TipoDenucio crear_PuertoSalida;
    @Inject
    PuertoSalida_Actualizar_TipoDenucio actualizar_PuertoSalida;
    @Inject
    PuertoSalida_Eliminar_TipoDenucio eliminar_PuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackbuscarTodosTipoDenucio")
    public Response getAll() {
        Controller_BuscarTodos_TipoDenucio controlador = new Controller_BuscarTodos_TipoDenucio(buscarTodos_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.buscarTodos()).build();
    }

    public Response fallbackbuscarTodosTipoDenucio() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackGetById")
    public Response getById(@PathParam("id") Long id) throws Exception {
        try {
            Controller_BuscarPorID_TipoDenucio controlador = new Controller_BuscarPorID_TipoDenucio(buscarPorID_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.buscarPorID_PuertoSalida(id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackGetById(@PathParam("id") Long id) {
        return Response.status(503).build();
    }

    @POST
    @Retry(maxRetries = 3, delay = 3000, abortOn = {ValidationException.class})
    @Fallback(fallbackMethod = "fallbackCrearTipoDenucio")
    public Response crearTipoDenucio(Request_Save_DTO_TipoDenucio dto) {
        Set<ConstraintViolation<Request_Save_DTO_TipoDenucio>> violations = validator.validate(dto);
        if(!violations.isEmpty()) {
            List<String> error = new ArrayList<>();
            violations.forEach(x-> error.add(x.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(error)).build();
        }
        Controller_Crear_TipoDenucio controlador = new Controller_Crear_TipoDenucio(crear_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.crear(dto)).build();
    }

    public Response fallbackCrearTipoDenucio(Request_Save_DTO_TipoDenucio dto) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackActualizarTipoDenucio")
    public Response actualizar(@PathParam("id") Long id, Request_Update_DTO_TipoDenucio dto) {
        Set<ConstraintViolation<Request_Update_DTO_TipoDenucio>> violations = validator.validate(dto);
        if(!violations.isEmpty()) {
            List<String> errors = new ArrayList<>();
            violations.forEach(x -> errors.add(x.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(errors)).build();
        }

        try {
            Controller_Actualizar_TipoDenucio controlador = new Controller_Actualizar_TipoDenucio(actualizar_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.actualizar(id, dto)).build();

        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }
    public Response fallbackActualizarTipoDenucio(Long id, Request_Update_DTO_TipoDenucio dto) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackEliminarTipoDenucio")
    public Response eliminarTipoDenuci(@PathParam("id") Long id) {
        try {
            Controller_Eliminar_TipoDenucio controlador = new Controller_Eliminar_TipoDenucio(eliminar_PuertoSalida);
            controlador.eliminarPorID(id);
            return Response.status(Response.Status.OK).entity(new GeneralStringResponse(REGISTRO_ELIMINADO +id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackEliminarTipoDenucio(Long id) {
        return Response.status(503).build();
    }
}
