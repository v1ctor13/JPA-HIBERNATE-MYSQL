package Test;

import Service.CadastroClienteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCadastroCliente {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();

        CadastroClienteService servico = new CadastroClienteService(manager);

        servico.cadastrarCliente("souza", "rua 44","5456");

    }

}
