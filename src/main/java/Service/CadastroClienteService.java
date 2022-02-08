package Service;

import Model.Cliente;
import Repository.ClienteRepository;

import javax.persistence.EntityManager;

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
}
