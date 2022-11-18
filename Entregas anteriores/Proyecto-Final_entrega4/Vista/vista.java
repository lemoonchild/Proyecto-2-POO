/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Permite mostrar textos en la consola, para el usuario, 
 * además de solicitar y recibir texto y números de parte de este.
 */

package Vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Modelo.Administrador_Evento;
import Modelo.Evento;
import Modelo.ListaDeUsuarios;
import Modelo.Voluntario;

public class vista {

    Scanner scan = new Scanner(System.in);
    public boolean AccesoVoluntario = false;
    public boolean AccesoAdmin = false;

    public ArrayList<Evento> eventosCreados = new ArrayList<Evento>();

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

    public int TipoDeUsuarioCreado() {

        System.out.println("Escriba el tipo de nombre de usuario que desea tener: ");
        int tipoUsuario = solicitarI("\t1. Usuario Voluntariado \n\t2. Usuario Administrativo\n");

        return tipoUsuario;

    }

    public void CrearUsuarioVoluntario(Voluntario voluntario1) {

        String nombre = solicitarS("Escriba el nombre de usuario que desea tener: ");
        voluntario1.setUsername(nombre);
        String password = solicitarS("Escriba la contraseña que desea tener: ");
        voluntario1.setPassword(password);
        int DPI = solicitarI("Escriba su numero de DPI: ");
        voluntario1.setDPI(DPI);
        voluntario1.setTypeUser(false);

        MostrarMensaje("¡Felicidades has creado tu usuario con exito!");
        // Falso es un usuario Voluntario y Verdadero es un usuario Administrador.
    }

    public void CrearUsuarioAdmin(Administrador_Evento admin1) {

        String usuario = solicitarS("Escriba el nombre de usuario que desea tener: ");
        admin1.setUsername(usuario);
        String password = solicitarS("Escriba la contraseña que desea tener: ");
        admin1.setPassword(password);
        int numT = solicitarI("Escriba su numero de telefono: ");
        admin1.setNumeroDeTelefono(numT);
        String nombre = solicitarS("Escriba su primer nombre y apellido: ");
        nombre.replaceAll(" ", "");
        nombre.toLowerCase();
        admin1.setNombrePersona(nombre);
        admin1.setTypeUser(true);

        MostrarMensaje("Felicidades has creado tu usuario con exito!");
        // Falso es un usuario Voluntario y Verdadero es un usuario Administrador.
    }

    public void IniciarSesion(ListaDeUsuarios listaDeUsuarios1) {

        int tipoUsuario = solicitarI("¿Tu usuario es tipo: \n1. Administrador \n2. Voluntario?");
        String usuario = solicitarS("Escriba su nombre de usuario: ");
        if (tipoUsuario == 1) {
            for (int i = 0; i <= listaDeUsuarios1.getUsuariosAdministrativos().size() - 1; i++) {
                if (usuario.equals(listaDeUsuarios1.getUsuariosAdministrativos().get(i).getUsername())) {
                    String password = solicitarS("Escriba su contraseña: ");
                    if (password.equals(listaDeUsuarios1.getUsuariosAdministrativos().get(i).getPassword())) {
                        AccesoAdmin = true;
                    }
                }
            }
            if (AccesoAdmin == false) {
                System.out.println("ERROR: El nombre de usuario o la contraseña no se encuntran en la base de datos");
                System.out.println("Revise que eligio correctamente el tipo de usuario");
            }
        }
        if (tipoUsuario == 2) {
            for (int i = 0; i <= listaDeUsuarios1.getUsuariosVoluntarios().size() - 1; i++) {
                if (usuario.equals(listaDeUsuarios1.getUsuariosVoluntarios().get(i).getUsername())) {
                    String password = solicitarS("Escriba su contraseña: ");
                    if (password.equals(listaDeUsuarios1.getUsuariosVoluntarios().get(i).getPassword())) {
                        AccesoVoluntario = true;
                    }
                }

            }
            if (AccesoVoluntario == false) {
                System.out.println("ERROR: El nombre de usuario o la contraseña no se encuntran en la base de datos");
                System.out.println("Revise que eligio correctamente el tipo de usuario");
            }
        }
    }

    /**
     * Muestra el menpu para que el administrador agregue la información necesaria
     * para la creación del evento
     * 
     * @param evento Clase evento
     */
    public Evento menuEvento() {

        System.out.println("\nCreación de Eventos para Administrador\n");

        String nombre = solicitarS("¿Cuál es el nombre del evento a crear?");

        int maxU = solicitarI("¿Cuál es a cantidad de usuarios permitidos?");

        String description = solicitarS("Escriba la descripción del evento: ");
        description.replaceAll(" ", "");
        description.toLowerCase();

        System.out.println("¿Qué día de la semana prefiere el evento?");
        int fecha = solicitarI("1. Lunes\n2. Martes\n3. Miércoles\n4. Jueves\n5. Viernes");
        
        System.out.println("¿Qué intervalo de tiempo quiere agregar sua actividad?");
        int bloque = solicitarI("1. 6AM-8AM\n2. 9AM-11AM\n 3.12PM-2PM\n4. 3PM-5PM\n6. 6PM-7PM"); 
        
        Evento eventoCreado = new Evento(nombre, fecha, maxU, description, bloque);

        MostrarMensaje("¡El evento ha sido guardado!");

        return eventoCreado;
    }

}
