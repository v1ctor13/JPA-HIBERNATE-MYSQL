package Repository;

import Model.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CidadeRepository {

    private final EntityManager manager;

    public CidadeRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Cidade create(Cidade c) {
        manager.getTransaction().begin();

        manager.persist(c);

        manager.getTransaction().commit();

        return c;
    }

    public Cidade read(Integer id){
        Query query = manager.createQuery("SELECT c FROM Cidade c WHERE c.id = " + id);
        Cidade c = (Cidade) query.getSingleResult();

        return c;
    }

    public EntityManager getManager(){
        return this.manager;
    }

}
