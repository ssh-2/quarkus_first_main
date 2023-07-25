package cl.bicevida.Liquidador.infrastructure;

import cl.bicevida.Liquidador.domain.DTO.Request_Save_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.DTO.Response_DTO_Liquidador;
import cl.bicevida.Liquidador.domain.modelo.Entity_Liquidador;
import cl.bicevida.Liquidador.domain.puertoSalida.PuertoSalida_Crear_Liquidador;
import cl.bicevida.Liquidador.utils.Mapper_Liquidador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_Liquidador implements PuertoSalida_Crear_Liquidador {

    private final PanacheRepository_Liquidador repository;

    private final Mapper_Liquidador mapper;

    public Crear_BD_Liquidador(PanacheRepository_Liquidador repository, Mapper_Liquidador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_Liquidador crear(Request_Save_DTO_Liquidador dto) {
        Entity_Liquidador entity = mapper.crearEntity(dto);
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
