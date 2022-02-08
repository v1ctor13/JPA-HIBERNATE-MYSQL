package Service;

import Model.Frete;
import Repository.FreteRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BuscaFreteService {

    private final EntityManager manager;

    public BuscaFreteService(EntityManager manager) {
        this.manager = manager;
    }

    public Frete buscarFretePorId(Integer id) {
        FreteRepository repository = new FreteRepository(manager);

        return repository.read(id);
    }

    public List<Frete> buscarFretesPorCliente(Integer id) {
        Query query = manager.createQuery("SELECT f FROM Frete f WHERE f.cliente = " + id);
        return query.getResultList();
    }

}
