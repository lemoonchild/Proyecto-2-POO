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
     * Muestra las posibles opciones de inicio que puede elegir y, por lo tanto,
     * realizar, el usuario.
     * 
     * @return entero con la opción solicitada por el usuario
     */
    public int Inicio() {
        System.out.println("\nBienvenid@ ¿Qué hará?");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir\n");

        return solicitarI(""); // Envia un entero con la opción del usuario.
    }

    /**
     * Muestra las posibles opciones que puede elegir y, por lo tanto, realizar, el
     * usuario. Se puede implementar al inicio de un While loop para mostrar
     * consultar al usuario sobre sus decisiones para luego llamar a otras
     * funciones.
     * 
     * @return entero con la opción solicitada por el usuario
     */
    public int Menu() {
        System.out.println("\n¿Qué hará?");
        System.out.println("1. Registrar horario");
        System.out.println("2. Asignarse a un voluntariado");
        System.out.println("3. Crear un nuevo programa de apoyo");
        System.out.println("4. Ver horarios asignados");
        System.out.println("5. Salir\n");

        return solicitarI(""); // Envia un entero con la opción del usuario.
    }

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