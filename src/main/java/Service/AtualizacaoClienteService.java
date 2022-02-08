package Service;

import Model.Cliente;
import Repository.CidadeRepository;
import Repository.ClienteRepository;

import javax.persistence.EntityManager;

public class AtualizacaoClienteService {

    private final EntityManager manager;

    public AtualizacaoClienteService(EntityManager manager) {
            this.manager = manager;
    }

    public Cliente atualizarCliente(Cliente cliente) {
        ClienteRepository repository = new ClienteRepository(manager);
        return repository.update(cliente);
    }

}
