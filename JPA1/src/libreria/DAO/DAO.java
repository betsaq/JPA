package libreria.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Betsa
 */
public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPA1PU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

   public void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();

    }

    public T eliminar(T objeto) {
        try {
            conectar();
            T objeto1 = em.merge(objeto);
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {

        }
        return null;
    }
}
