package Test;

import Model.Cliente;
import Service.BuscaClienteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClienteTest {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();

        BuscaClienteService service = new BuscaClienteService(manager);
        Cliente c = service.buscarClientePorId(3);

        System.out.println("nome: " + c.getNome());

        manager.close();
        factory.close();

    }
}

