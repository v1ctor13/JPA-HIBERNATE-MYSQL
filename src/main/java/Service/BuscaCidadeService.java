package Service;

import Model.Cidade;
import Repository.CidadeRepository;

import javax.persistence.EntityManager;

public class BuscaCidadeService {

    private final EntityManager manager;

    public BuscaCidadeService(EntityManager manager) {
        this.manager = manager;
    }

    public Cidade buscarCidadePorId(Integer id) {
        CidadeRepository repository = new CidadeRepository(manager);

        return repository.read(id);
    }

}
