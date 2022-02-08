package Service;

import Model.Cidade;
import Repository.CidadeRepository;

import javax.persistence.EntityManager;

public class CadastroCidadeService {

    private final EntityManager manager;

    public CadastroCidadeService(EntityManager manager) {
        this.manager = manager;
    }

    public void cadastrarCidade(String nome, String UF, Float taxa) {
        CidadeRepository repository = new CidadeRepository(manager);
        Cidade cidade = new Cidade(nome, UF, taxa);
        repository.create(cidade);
    }
}
