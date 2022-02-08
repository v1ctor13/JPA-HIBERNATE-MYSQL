package Service;

import Model.Cliente;
import Repository.ClienteRepository;

import javax.persistence.EntityManager;

public class BuscaClienteService {

    private final EntityManager manager;

    public BuscaClienteService(EntityManager manager) {
        this.manager = manager;
    }

    public Cliente buscarClientePorId(Integer id) {
        ClienteRepository repository = new ClienteRepository(manager);

        return repository.read(id);
    }

}
