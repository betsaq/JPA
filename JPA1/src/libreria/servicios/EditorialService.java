package libreria.servicios;

import java.util.Scanner;
import libreria.DAO.EditorialDAO;
import libreria.entidades.Editorial;

/**
 *
 * @author Betsa
 */
public class EditorialService {

    Scanner leer = new Scanner(System.in);

    private EditorialDAO DAO;

//    public EditorialService(EditorialService EditorialService) {
//        this.EditorialService = EditorialService;
//    }
    
    
    public Editorial ingresarEditorial() {
        Editorial editorial = new Editorial();

        try {
            System.out.println("Ingrese nombre de la Editorial");
            editorial.setNombre(leer.next());

            DAO.guardar(editorial);
            System.out.println("Editorial ingresada correctamente");
        } catch (Exception e) {

            System.out.println("No se pudo ingresar la editorial en la base de datos");
        }
        return editorial;

    }
}
