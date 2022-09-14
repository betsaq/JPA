package libreria.DAO;

import java.util.ArrayList;
import java.util.Collection;
import static libreria.entidades.Autor_.nombre;
import libreria.entidades.Libro;

/**
 *
 * @author Betsa
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro Libro) {
        super.guardar(Libro);

    }

    public Libro buscarPorISBN(Long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn LIKE :isbn").setParameter("ISBN", isbn).getSingleResult();
        desconectar();
        return libro;

    }
    
    
     public Libro buscarPorTitulo (String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo").setParameter("TITULO", titulo).getSingleResult();
        desconectar();
        return libro;

    }

    public ArrayList<Libro> ListarLibros() {
        conectar();
        ArrayList<Libro> libros = (ArrayList<Libro>) em.createQuery("SELECT a FROM Libro a").getResultList();
        desconectar();
        return libros;

    }
//11) Búsqueda de un libro/s por nombre de Autor.

    public Libro buscarPorNombreautor(AutorDAO autor) {

        conectar();
        
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l, Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return libro;

    }
//12) Búsqueda de un libro/s por nombre de Editorial.
    
        public Libro buscarPorEditorial(EditorialDAO Editorial) {

        conectar();
        
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l, Editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return libro;

    }
    
        
        
        
        
    
    
}
