package Service;

import Model.Cliente;
import Repository.ClienteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BuscaClienteService {

    private final EntityManager manager;

    public BuscaClienteService(EntityManager manager) {
        this.manager = manager;
    }

    public Cliente buscarClientePorId(Integer id) {
        ClienteRepository repository = new ClienteRepository(manager);

        return repository.read(id);
    }

    //teste
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        BuscaClienteService service = new BuscaClienteService(manager);

        Cliente c = service.buscarClientePorId(10);

        System.out.println("nome: " + c.getNome());

        manager.close();
        factory.close();
    }

}
