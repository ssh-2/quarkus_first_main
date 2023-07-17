package cl.bicevida.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

public class PersonaResource {

    @Inject
    PersonaRepository personaRepository;

    @POST
    public Persona crearPersona(Persona persona) {
        return personaRepository.guardar(persona);
    }

    @GET
    @Path("/{id}")
    public Persona obtenerPersona(@PathParam("id") Long id) {
        return personaRepository.buscarPorId(id);
    }

    @PUT
    @Path("/{id}")
    public void actualizarPersona(@PathParam("id") Long id, Persona personaActualizada) {
        Persona persona = personaRepository.buscarPorId(id);
        if (persona != null) {
            persona.setNombresRazonSocial(personaActualizada.getNombresRazonSocial());
            persona.setApellido1(personaActualizada.getApellido1());
            persona.setApellido2(personaActualizada.getApellido2());
            persona.setFechaNacimiento(personaActualizada.getFechaNacimiento());
            persona.setSexo(personaActualizada.getSexo());
            persona.setEmail(personaActualizada.getEmail());
            personaRepository.actualizar(persona);
        }
    }

    @DELETE
    @Path("/{id}")
    public void eliminarPersona(@PathParam("id") Long id) {
        Persona persona = personaRepository.buscarPorId(id);
        if (persona != null) {
            personaRepository.eliminar(persona);
        }
    }

}
