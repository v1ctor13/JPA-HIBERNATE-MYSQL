package Service;

import Model.Cidade;
import Repository.CidadeRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BuscaCidadeService {

    private final EntityManager manager;

    public BuscaCidadeService(EntityManager manager) {
        this.manager = manager;
    }

    public Cidade buscarCidadePorId(Integer id) {
        CidadeRepository repository = new CidadeRepository(manager);

        return repository.read(id);
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();

        BuscaCidadeService service = new BuscaCidadeService(manager);
        Cidade c = service.buscarCidadePorId(4);

        manager.close();
        factory.close();
    }

}
