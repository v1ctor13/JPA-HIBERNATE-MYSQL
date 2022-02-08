package Service;

import Model.Frete;
import Repository.FreteRepository;

import javax.persistence.EntityManager;

public class AtualizacaoFreteService {
    private final EntityManager manager;

    public AtualizacaoFreteService(EntityManager manager) {
        this.manager = manager;
    }

    public Frete atualizarFrete(Frete frete) {
        FreteRepository repository = new FreteRepository(manager);
        return repository.update(frete);
    }
}
