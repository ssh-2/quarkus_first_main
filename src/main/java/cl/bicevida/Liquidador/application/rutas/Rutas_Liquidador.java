package cl.bicevida.Liquidador.application.rutas;


import cl.bicevida.Liquidador.application.controladores.*;
import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Request_Update_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.*;
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

@Path("/api/liquidador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class Rutas_Liquidador {

    @Inject
    Validator validator;

    @Inject
    PuertoSalida_BuscarTodos_Liquidador buscarTodos_PuertoSalida;
    @Inject
    PuertoSalida_BuscarPorID_Liquidador buscarPorID_PuertoSalida;
    @Inject
    PuertoSalida_Crear_Liquidador crear_PuertoSalida;
    @Inject
    PuertoSalida_Actualizar_Liquidador actualizar_PuertoSalida;
    @Inject
    PuertoSalida_Eliminar_Liquidador eliminar_PuertoSalida;

    @GET
    @APIResponses(
            value = { @APIResponse(responseCode = "200", description = "OK"),
                    @APIResponse(responseCode = "400", description = "No encontrado")}
    )
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackBuscarTodosLiquidadores")
    public Response getAll() {
        Controller_BuscarTodos_Liquidador controlador = new Controller_BuscarTodos_Liquidador(buscarTodos_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.buscarTodos()).build();
    }

    public Response fallbackBuscarTodosLiquidadores() {
        return Response.status(503).build();
    }

    @GET
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class, InternalServerErrorException.class})
    @Fallback(fallbackMethod = "fallbackObtenerLiquidador")
    public Response getById(@PathParam("id") Long id) throws Exception{
        try {
            Controller_BuscarPorID_Liquidador controlador = new Controller_BuscarPorID_Liquidador(buscarPorID_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.buscarPorID(id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackObtenerLiquidador(@PathParam("id") Long id) {
        return Response.status(503).build();
    }
    @POST
    @Retry(maxRetries = 3, delay = 3000, abortOn = {ValidationException.class})
    @Fallback(fallbackMethod = "fallbackCrearLiquidador")
    public Response crear(Request_Save_DTO_Liquidador dto) {
        Set<ConstraintViolation<Request_Save_DTO_Liquidador>> violations = validator.validate(dto);
        if(!violations.isEmpty()) {
            List<String> error = new ArrayList<>();
            violations.forEach(x -> error.add(x.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(error)).build();

        }
        Controller_Crear_Liquidador controlador = new Controller_Crear_Liquidador(crear_PuertoSalida);
        return Response.status(Response.Status.OK).entity(controlador.crear(dto)).build();
    }
    public Response fallbackCrearLiquidador(Request_Save_DTO_Liquidador dto) {
        return Response.status(503).build();
    }

    @PUT
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000)
    @Fallback(fallbackMethod = "fallbackActualizarLiquidador")
    public Response actualizarLiquidador(@PathParam("id")Long id, Request_Update_DTO_Liquidador  dto) {
        Set<ConstraintViolation<Request_Update_DTO_Liquidador>> violations = validator.validate(dto);
        if(!violations.isEmpty()) {
            List<String> error = new ArrayList<>();
            violations.forEach(x-> error.add(x.getMessage()));
            return Response.status(Response.Status.BAD_REQUEST).entity(new ValidationErrorResponse(error)).build();
        }

        try {
            Controller_Actualizar_Liquidador controlador = new Controller_Actualizar_Liquidador(actualizar_PuertoSalida);
            return Response.status(Response.Status.OK).entity(controlador.actualizar(id, dto)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }

    public Response fallbackActualizarLiquidador(Long id, Request_Update_DTO_Liquidador dto) {
        return Response.status(503).build();
    }

    @DELETE
    @Path("/{id}")
    @Retry(maxRetries = 3, delay = 3000, abortOn = {NotFoundException.class})
    @Fallback(fallbackMethod = "fallbackEliminarPais")
    public Response eliminarLiquidador(@PathParam("id") Long id) {
        try {
            Controller_Eliminar_Liquidador controlador = new Controller_Eliminar_Liquidador(eliminar_PuertoSalida);
            controlador.eliminarPorID(id);
            return Response.status(Response.Status.OK).entity(new GeneralStringResponse(REGISTRO_ELIMINADO + id)).build();
        } catch (NotFoundException e) {
            return Response.status(e.getResponse().getStatus()).entity(new GeneralErrorResponse(e.getMessage())).build();
        }
    }
    public Response fallbackEliminarPais(Long id) {
        return Response.status(503).build();
    }
}
