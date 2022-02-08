package Service;

import Model.Cidade;
import Model.Cliente;
import Model.Frete;
import Repository.ClienteRepository;
import Repository.FreteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    // teste ↓
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        BuscaClienteService buscaClienteService = new BuscaClienteService(manager);
        BuscaCidadeService buscaCidadeService = new BuscaCidadeService(manager);

        manager.getTransaction().begin();

        Cliente cliente = buscaClienteService.buscarClientePorId(3);
        Cidade cidade = buscaCidadeService.buscarCidadePorId(4);

        CadastroFreteService service = new CadastroFreteService(manager);
        service.cadastrarFrete("produto: rx 550 2Gb", 1f, 10f, cliente, cidade);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
