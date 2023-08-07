package cl.bicevida.Parentesco.infraestructure;

import cl.bicevida.Parentesco.domain.modelo.Entity_Parentesco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class PanacheRepository_Parentesco implements PanacheRepository<Entity_Parentesco> {

    public PanacheRepository_Parentesco() {
    }


}
