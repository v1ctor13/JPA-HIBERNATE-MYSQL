package Service;

import Model.Cliente;
import Repository.ClienteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroClienteService {

    private final EntityManager manager;

    public CadastroClienteService(EntityManager manager) {
        this.manager = manager;
    }

    public void cadastrarCliente(String nome, String endereco, String telefone) {
        ClienteRepository repository = new ClienteRepository(manager);
        Cliente cliente = new Cliente(nome, endereco, telefone);
        repository.create(cliente);
    }

    //teste
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Cliente c = new Cliente("victor", "condominio B", "98765432");

        manager.persist(c);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
