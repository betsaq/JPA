package libreria.servicios;

import java.util.Scanner;
import libreria.DAO.AutorDAO;
import libreria.entidades.Autor;

/**
 *
 * @author Betsa
 */
public class AutorService {

    Scanner leer = new Scanner(System.in);
    private AutorDAO DAO;

    public Autor ingresarAutor() {
        Autor autor = new Autor();

        try {
            System.out.println("Ingrese nombre del autor");
            autor.setNombre(leer.next());

            autor.setAlta(true);

            DAO.guardar(autor);
            System.out.println("Autor ingresado correctamente");
        } catch (Exception e) {

            System.out.println("No se pudo ingresar el autor en la base de datos");
        }
        return autor;
        
    }

}


