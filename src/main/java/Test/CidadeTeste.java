package Test;

import Model.Cidade;
import Service.BuscaCidadeService;
import Service.CadastroCidadeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CidadeTeste {

    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();

        // cenário
//        CadastroCidadeService servico = new CadastroCidadeService(manager);

//        servico.CadastrarCidade("Teresina", "PI", 50f);

        BuscaCidadeService service = new BuscaCidadeService(manager);

        Cidade c = service.buscarCidadePorId(4);

        manager.close();
        factory.close();

    }
}
