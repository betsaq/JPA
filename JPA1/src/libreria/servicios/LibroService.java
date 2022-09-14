package libreria.servicios;

import java.util.Objects;
import java.util.Scanner;
import libreria.DAO.AutorDAO;
import libreria.DAO.EditorialDAO;
import libreria.DAO.LibroDAO;
//import libreria.entidades.Autor;
//import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author Betsa
 */
public class LibroService {

    Scanner leer = new Scanner(System.in);
    private final LibroDAO DAO;
    private EditorialService EdictorialService;
    private AutorService AutorService;

    public LibroService() {
        this.DAO = new LibroDAO();
    }

    public void menuLibro() {
        String aux;
        do {
            System.out.println("SELECCIONE UNA OPCIÓN"
                    + "1- Crear un libro "
                    + "2- Dar de baja un libro");
            switch (aux = leer.next()) {
                case "1":
                    crearLibro();
                    break;
                case "2":
                    bajaLibro();
                    break;

            }
        } while (aux != 1 && aux != 2)
        {
            System.out.println("OPCION NO VALIDA");
        }

    }

    public Libro crearLibro() {
        Libro libro = new Libro();
        AutorDAO autor = new AutorDAO();
        EditorialDAO editorial = new EditorialDAO();

        try {
            System.out.println("Ingrese ISBN");
            libro.setIsbn(leer.nextLong());
            System.out.println("Ingrese Titulo del libro");
            libro.setTitulo(leer.next());
            System.out.println("Ingrese año");
            libro.setAnio(leer.nextInt());
            System.out.println("Ingrese ejemplares");
            libro.setEjemplares(leer.nextInt());
            System.out.println("Ingrese Autor");
            String AutorIngresado = leer.next();

            if (autor.buscarPorNombre(AutorIngresado) == null) {
                AutorService.ingresarAutor();
            }

            System.out.println("Ingrese Editorial");
            String EditorialIngresada = leer.next();

            if (editorial.buscarPorNombre(EditorialIngresada) == null) {
                EdictorialService.ingresarEditorial();

                libro.setAlta(true);
                System.out.println("El libro ha sido ingresado EXITOSAMENTE");
                DAO.guardar(libro);

            }
        } catch (Exception e) {
            System.out.println("ERROR AL CARGAR EL LIBRO");
        }

        return libro;

    }

    public Libro bajaLibro() {
        LibroDAO libro = new LibroDAO();

        System.out.println("INGRESE ISBN PARA DAR DE BAJA");
        Long ISBNBaja = leer.nextLong();

        for (Libro Libro : libro.ListarLibros()) {
            if (Objects.equals(ISBNBaja, Libro.getIsbn())) {
                try {

                    Libro.setAlta(false);

                    DAO.eliminar(Libro);

                } catch (Exception e) {
                    System.out.println("ERROR AL DAR DE BAJA EL LIBRO");
                }

            }

            return Libro;
        }
