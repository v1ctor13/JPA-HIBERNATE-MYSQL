package Service;

import Model.Cliente;
import Repository.CidadeRepository;
import Repository.ClienteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtualizacaoClienteService {

    private final EntityManager manager;

    public AtualizacaoClienteService(EntityManager manager) {
            this.manager = manager;
    }

    public Cliente atualizarCliente(Cliente cliente) {
        ClienteRepository repository = new ClienteRepository(manager);
        return repository.update(cliente);
    }

    //teste
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        AtualizacaoClienteService acs = new AtualizacaoClienteService(manager);
        BuscaClienteService buscaService = new BuscaClienteService(manager);
        manager.getTransaction().begin();

        // recuperando cliente do banco de dados
        Cliente c = buscaService.buscarClientePorId(1);
        // mudando o nome do cliente
        c.setNome("valter");

        // atualizando
        acs.atualizarCliente(c);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

}
