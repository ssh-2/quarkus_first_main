package cl.bicevida.TipoCuentaBanco.infrastructure;

import cl.bicevida.TipoCuentaBanco.domain.DTO.Request_Save_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.DTO.Response_DTO_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.modelo.Entity_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.domain.puertoSalida.PuertoSalida_Crear_TipoCuentaBanco;
import cl.bicevida.TipoCuentaBanco.utils.Mapper_TipoCuentaBanco;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class Crear_BD_TipoCuentaBanco implements PuertoSalida_Crear_TipoCuentaBanco {

    private final PanacheRepository_TipoCuentaBanco repository;

    private final Mapper_TipoCuentaBanco mapper;

    public Crear_BD_TipoCuentaBanco(PanacheRepository_TipoCuentaBanco repository, Mapper_TipoCuentaBanco mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Retry(maxRetries = 3, delay = 3000)
    @Override
    public Response_DTO_TipoCuentaBanco crear(Request_Save_DTO_TipoCuentaBanco dto) {
        Entity_TipoCuentaBanco entity = mapper.crearEntity(dto);
        repository.persist(entity);
        return mapper.crearDTO(entity);
    }
}
