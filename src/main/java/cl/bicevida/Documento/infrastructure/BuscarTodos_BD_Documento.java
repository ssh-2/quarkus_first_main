package cl.bicevida.Documento.infrastructure;

import cl.bicevida.Documento.domain.DTO.Response_DTO_Documento;
import cl.bicevida.Documento.domain.modelo.Entity_Documento;
import cl.bicevida.Documento.domain.puertoSalida.PuertoSalida_BuscarTodos_Documento;
import cl.bicevida.Documento.utils.Mapper_Documento;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BuscarTodos_BD_Documento implements PuertoSalida_BuscarTodos_Documento {

    private final PanacheRepository_Documento repository;

    private final Mapper_Documento mapper;

    public BuscarTodos_BD_Documento(PanacheRepository_Documento repository, Mapper_Documento mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Response_DTO_Documento> buscarTodos() {
        List<Entity_Documento> entities= repository.listAll();
        return mapper.crearDTO(entities);
    }
}
