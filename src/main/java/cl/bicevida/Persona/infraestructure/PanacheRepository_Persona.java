package cl.bicevida.Persona.infraestructure;

import cl.bicevida.Persona.domain.modelo.Entity_Persona;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class PanacheRepository_Persona implements PanacheRepository<Entity_Persona> {

    public PanacheRepository_Persona() {
    }

    public Entity_Persona consultarPorRut(String rut){
        log.info("Consultado si existe el rut: " + rut);
        return find("rut", rut).firstResult();
    }

}
