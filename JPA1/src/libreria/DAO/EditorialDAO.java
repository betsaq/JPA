
package libreria.DAO;

import java.util.Collection;
import libreria.entidades.Editorial;

/**
 *
 * @author Betsa
 */
public class EditorialDAO extends DAO<Editorial>{
    
    @Override
    public void guardar(Editorial Editorial) {
        super.guardar(Editorial);

    }

    public Editorial buscarPorID(Long id) {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT a FROM Editorial a WHERE a.id LIKE :id").setParameter("ID", id).getSingleResult();
        desconectar();
        return editorial;

    }

    public Collection<Editorial> ListarEditorial() {
        conectar();
        Collection<Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
        desconectar();
        return editoriales;

    }

    public Editorial buscarPorNombre(String nombre) {

        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT a FROM Editorial a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;

    }
    
    
    
}
