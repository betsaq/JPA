
package libreria.DAO;

import java.util.Collection;
import libreria.entidades.Autor;

/**
 *
 * @author Betsa
 */
public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor Autor) {
        super.guardar(Autor);

    }

    public Autor buscarPorID(Long id) {
        conectar();
        System.out.println("INGRESE ID A BUSCAR");
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("ID", id).getSingleResult();
        desconectar();
        return autor;

    }

    public Collection<Autor> ListarAutor() {
        conectar();
        Collection<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;

    }

    public Autor buscarPorNombre(String nombre) {

        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;

    }

}
