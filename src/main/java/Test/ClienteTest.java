package Test;

import Model.Cliente;
import Service.AtualizacaoClienteService;
import Service.BuscaClienteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClienteTest {

    public static void main(String[] args) {

        testeCadastrarCliente();

    }

    static private void testeCadastrarCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Cliente c = new Cliente("Martins", "condominio A", "12345678");

        manager.persist(c);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    static private void testeBuscaCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        BuscaClienteService service = new BuscaClienteService(manager);

        Cliente c = service.buscarClientePorId(3);

        System.out.println("nome: " + c.getNome());

        manager.close();
        factory.close();
    }

    static private void testeAtualizaCliente() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();
        AtualizacaoClienteService acs = new AtualizacaoClienteService(manager);
        BuscaClienteService buscaService = new BuscaClienteService(manager);
        manager.getTransaction().begin();

        // recuperando cliente do banco de dados
        Cliente c = buscaService.buscarClientePorId(1);
        // mudando o nome do cliente
        c.setNome("valter");

        // atualizando
        acs.atualizarCliente(c);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}

