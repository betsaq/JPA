//
//c) Servicios
//AutorServicio
//Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
//para administrar autores (consulta, creación, modificación y eliminación).
//EditorialServicio
//Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
//para administrar editoriales (consulta, creación, modificación y eliminación)
//LibroServicio
//Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
//para administrar libros (consulta, creación, modificación y eliminación).
//d) Main
//Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
//para interactuar con el usuario. En esta clase se muestra el menú de opciones con las
//operaciones disponibles que podrá realizar el usuario.
//e) Tareas a Realizar
//Al alumno le toca desarrollar, las siguientes funcionalidades:
//1) Crear base de datos Librería
//2) Crear unidad de persistencia
//3) Crear entidades previamente mencionadas ( excepto Préstamo )
//4) Generar las tablas con JPA
//5) Crear servicios previamente mencionados.
//6) Crear los métodos para persistir entidades en la base de datos librería
//7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
//8) Búsqueda de un Autor por nombre.
//9) Búsqueda de un libro por ISBN.
//10) Búsqueda de un libro por Título.
//11) Búsqueda de un libro/s por nombre de Autor.
//12) Búsqueda de un libro/s por nombre de Editorial.
//13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
//• Validar campos obligatorios.
//• No ingresar datos duplicados. 
package libreria;

import java.util.Scanner;
import libreria.DAO.AutorDAO;
import libreria.DAO.EditorialDAO;
import libreria.DAO.LibroDAO;
import libreria.servicios.AutorService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;

/**
 *
 * @author Betsa
 */
public class libreria {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String aux;
        LibroService LS = new LibroService();
        LibroDAO LD = new LibroDAO();
        AutorDAO AD = new AutorDAO();
        AutorService AS = new AutorService();
        EditorialDAO ED = new EditorialDAO();
        EditorialService ES = new EditorialService();

        do {
            System.out.println("QUE ACCIÓN DESEA REALIZAR?");
            System.out.println("1) Consulta, creación, modificación y/o eliminación de un libro.\n"
                    + "2) Consulta, creación, modificación y/o eliminación de un autor.\n"
                    + "3) Consulta, creación, modificación y/o eliminación de una editorial.\n"
                    + "4) Búsqueda de un Autor por nombre.\n"
                    + "5) Búsqueda de un libro por ISBN.\n"
                    + "6) Búsqueda de un libro por Título.\n"
                    + "7) Búsqueda de un libro/s por nombre de Autor.\n"
                    + "8) Búsqueda de un libro/s por nombre de Editorial.\n."
                    + "9) Salir.");

            aux = leer.next();

            switch (aux) {
                case "1":
                    LS.menuLibro();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    System.out.println("Que autor desea buscar?");
                    String nombre = leer.next();
                    AD.buscarPorNombre(nombre);
                    break;
                case "5":
                    System.out.println("Que ISBN desea buscar?");
                    Long Isbn = leer.nextLong();
                    LD.buscarPorISBN(Isbn);
                    break;
                case "6":
                    System.out.println("Que titulo desea buscar?");
                    String titulo = leer.next();
                    LD.buscarPorTitulo(titulo);
                    break;
                case "7":
                    //   System.out.println("Que autor desea buscar?");
                    //   String nombre1= leer.next();
                    LD.buscarPorNombreautor(AD);
                    break;
                case "8":
                    System.out.println("Que titulo desea buscar?");
                    String titulo1 = leer.next();
                    LD.buscarPorTitulo(titulo1);
                    break;
                case "9":
                    System.out.println("EL PROGRAMA HA FINALIZADO");
            }
            while (!"9".equals(aux)) {

            }

        }
