package Test;

import Model.Cidade;
import Model.Cliente;
import Model.Frete;
import Service.BuscaCidadeService;
import Service.BuscaClienteService;
import Service.BuscaFreteService;
import Service.CadastroFreteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FreteTeste {

    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab4");
        EntityManager manager = factory.createEntityManager();

        BuscaClienteService buscaClienteService = new BuscaClienteService(manager);
        BuscaCidadeService buscaCidadeService = new BuscaCidadeService(manager);
        BuscaFreteService bfs = new BuscaFreteService(manager);

        Cliente cliente = buscaClienteService.buscarClientePorId(3);
        Cidade cidade = buscaCidadeService.buscarCidadePorId(4);

        // cenario
        CadastroFreteService service = new CadastroFreteService(manager);
        service.cadastrarFrete("produto: gtx 1080", 1f, 10f, cliente, cidade);

        List<Frete> fretes = bfs.buscarFretesPorCliente(3);

        for(Frete f : fretes){
            System.out.println("Descricao: " + f.getDescricao());
        }

        manager.close();
        factory.close();

    }
}
