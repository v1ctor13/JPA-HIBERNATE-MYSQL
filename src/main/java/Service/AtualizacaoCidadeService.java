package Service;

import Model.Cidade;
import Repository.CidadeRepository;

import javax.persistence.EntityManager;

public class AtualizacaoCidadeService {
    private final EntityManager manager;

    public AtualizacaoCidadeService(EntityManager manager) {
        this.manager = manager;
    }

    public Cidade atualizarCliente(Cidade cidade) {
        CidadeRepository repository = new CidadeRepository(manager);
        return repository.update(cidade);
    }
}
