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

    public Cliente update(Cliente c) {
        if(c == null){
            System.out.println("Não foi posível encontrar um cliente com esse ID.");
            return null;
        }
        c = this.manager.merge(c);
        return c;
    }

    public EntityManager getManager(){
        return this.manager;
    }

}
