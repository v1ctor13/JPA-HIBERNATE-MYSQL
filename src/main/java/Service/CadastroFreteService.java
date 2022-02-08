package Service;

import Model.Cidade;
import Model.Cliente;
import Model.Frete;
import Repository.ClienteRepository;
import Repository.FreteRepository;

import javax.persistence.EntityManager;

public class CadastroFreteService {

    private final EntityManager manager;

    public CadastroFreteService(EntityManager manager) {
        this.manager = manager;
    }

    public void cadastrarFrete(String descricao, Float peso, Float valorFixo, Cliente cliente, Cidade cidade) {
        FreteRepository repository = new FreteRepository(manager);
        Float valor = (peso * valorFixo) + cidade.getTaxa();
        Frete frete = new Frete(descricao, peso, valor, cliente, cidade);
        repository.create(frete);
    }

}
