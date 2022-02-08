package Service;

import Model.Frete;
import Repository.FreteRepository;
import Test.FreteTeste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    //TESTE
    public static void main(String[] args) {
        //testeBuscarFretePorCliente();
        testeBuscarFretePorId();
    }

    public static void testeBuscarFretePorId(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        BuscaFreteService bfs = new BuscaFreteService(manager);

        Frete f = bfs.buscarFretePorId(13);
        System.out.println("Descrição frete: " + f.getDescricao());

        manager.close();
        factory.close();
    }

    public static void testeBuscarFretePorCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        BuscaFreteService bfs = new BuscaFreteService(manager);

        List<Frete> fretes = bfs.buscarFretesPorCliente(2);

        for(Frete f : fretes){
            System.out.println("Descricao: " + f.getDescricao());
        }

        manager.close();
        factory.close();
    }

}
