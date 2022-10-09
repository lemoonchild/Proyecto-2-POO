import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Integrante: Fabiola Contreras 22787
 * 
 * vista: permite mostrar textos en la consola, para el usuario, además de
 * solicitar y recibir texto y números de parte del mismo.
 */
public class vista {
    Scanner scan = new Scanner(System.in);

    /**
     * Imprime una solicitud y recibe un dato tipo int
     * Evita una excepción -InputMismatchException- volviendo a solicitar el dato en
     * caso de que ocurra.
     * 
     * @param solicitud texto que describe lo solicitado
     * @return entero ingresado por el usuario
     */
    public int solicitarI(String solicitud) {
        System.out.println(solicitud);
        int solicitar = 0;
        Boolean correcto = false;
        do {
            try {
                solicitar = scan.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("¡Cuidado! Ingresa un número entero.");
            }
        } while (correcto == false);
        scan.nextLine(); // Elimina la posibilidad de saltarse una linea de solicitud después
        return solicitar;
    }

    /**
     * Imprime una solicitud y recibe un dato tipo String.
     * 
     * @param solicitud texto que describe la solicitud al usuario
     * @return regresa el texto dado por el usuario
     */
    public String solicitarS(String solicitud) {
        System.out.println(solicitud);
        String recepcion = scan.nextLine();
        return recepcion;
    }

    /**
     * Imprime un texto solicitado
     * 
     * @param text texto a imprimir
     */
    public void MostrarMensaje(String text) {
        System.out.println("\n" + text);
    }
}