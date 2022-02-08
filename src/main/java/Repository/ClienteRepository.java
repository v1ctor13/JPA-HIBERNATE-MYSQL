package Repository;

import Model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteRepository {

    private final EntityManager manager;

    public ClienteRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Cliente create(Cliente c) {
        manager.getTransaction().begin();

        manager.persist(c);

        manager.getTransaction().commit();

        return c;
    }

    public Cliente read(Integer id){
        Query query = manager.createQuery("SELECT c FROM Cliente c WHERE c.id = " + id);
        Cliente c = (Cliente) query.getSingleResult();

        return c;
    }

    public EntityManager getManager(){
        return this.manager;
    }

}
