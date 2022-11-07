package Vista;
import java.util.InputMismatchException;
import java.util.Scanner;

import Modelo.Administrador_Evento;
import Modelo.ListaDeUsuarios;
import Modelo.Voluntario;

/**
 * Integrante: Fabiola Contreras 22787
 * 
 * vista: permite mostrar textos en la consola, para el usuario, además de
 * solicitar y recibir texto y números de parte del mismo.
 */
public class vista {
    Scanner scan = new Scanner(System.in);
    String RespuestaS;
    public int RespuestaI;
    public boolean AccesoVoluntario = false;
    public boolean AccesoAdmin = false;

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

    public void TipoDeUsuarioCreado(){
        System.out.println("Escriba el tipo de nombre de usuario que desea tene:");
        System.out.println("1. Usuario Voluntariado");
        System.out.println("2. Usuario Administrativo"+"\n");
        RespuestaI = scan.nextInt();
    }

    public void CrearUsuarioVoluntario(Voluntario voluntario1){
        System.out.println("Escriba el nombre de usuario que desea tener: ");
        RespuestaS = scan.next();
        voluntario1.setUsername(RespuestaS);
        System.out.println("Escriba la contraseña que desea tener: ");
        RespuestaS = scan.next();
        voluntario1.setPassword(RespuestaS);
        System.out.println("Escriba su numero de DPI: ");
        RespuestaI = scan.nextInt();
        voluntario1.setDPI(RespuestaI);
        voluntario1.setTypeUser(false);
        System.out.println("Felicidades has creado tu usuario con exito!");
        //Falso es un usuario Voluntario y Verdadero es un usuario Administrador.
    }

    public void CrearUsuarioAdmin(Administrador_Evento admin1){
        System.out.println("Escriba el nombre de usuario que desea tener: ");
        RespuestaS = scan.next();
        admin1.setUsername(RespuestaS);
        System.out.println("Escriba la contraseña que desea tener: ");
        RespuestaS = scan.next();
        admin1.setPassword(RespuestaS);
        System.out.println("Escriba su numero de telefono: ");
        RespuestaS = scan.next();
        admin1.setNumeroDeTelefono(RespuestaS);
        System.out.println("Escriba su primer nombre y apellido: ");
        RespuestaS = scan.next();
        RespuestaS.replaceAll(" ", "");
        RespuestaS.toLowerCase();
        admin1.setNombrePersona(RespuestaS);
        admin1.setTypeUser(true);
        System.out.println("Felicidades has creado tu usuario con exito!");
        //Falso es un usuario Voluntario y Verdadero es un usuario Administrador.
    }

    public void IniciarSecion(ListaDeUsuarios listaDeUsuarios1){
        System.out.println("¿Tu usuario es tipo: \n1.administrador \n2.voluntario?");
        RespuestaI = scan.nextInt();
        System.out.println("Escriba su nombre de usuario: ");
        RespuestaS = scan.next();
        if(RespuestaI == 1){
            for(int i = 0; i <= listaDeUsuarios1.getUsuariosAdministrativos().size()-1;i++){
                if(RespuestaS.equals(listaDeUsuarios1.getUsuariosAdministrativos().get(i).getUsername())){
                    System.out.println("Escriba su contraseña: ");
                    RespuestaS = scan.next();
                    if(RespuestaS.equals(listaDeUsuarios1.getUsuariosAdministrativos().get(i).getPassword())){
                        AccesoAdmin = true;
                    }
                }
            }
            if(AccesoVoluntario == false){
                System.out.println("ERROR: El nombre de usuario o la contraseña no se encuntran en la base de datos");
                System.out.println("Revise que eligio correctamente el tipo de usuario");
            }
        }
        if(RespuestaI == 2){
            for(int i = 0; i <= listaDeUsuarios1.getUsuariosVoluntarios().size()-1;i++){
                if(RespuestaS.equals(listaDeUsuarios1.getUsuariosVoluntarios().get(i).getUsername())){
                    System.out.println("Escriba su contraseña: ");
                    if(RespuestaS.equals(listaDeUsuarios1.getUsuariosVoluntarios().get(i).getPassword())){
                        AccesoVoluntario = true;
                    }
                }
                
            }
            if(AccesoAdmin == false|| AccesoVoluntario == false){
                System.out.println("ERROR: El nombre de usuario o la contraseña no se encuntran en la base de datos");
                System.out.println("Revise que eligio correctamente el tipo de usuario");
            }



        







    }

     
}
 public String getRespuestaS() {
        return RespuestaS;
    }

    public void setRespuestaS(String respuestaS) {
        RespuestaS = respuestaS;
    }

    public int getRespuestaI() {
        return RespuestaI;
    }

    public void setRespuestaI(int respuestaI) {
        RespuestaI = respuestaI;
    }

    public boolean isAccesoVoluntario() {
        return AccesoVoluntario;
    }

    public void setAccesoVoluntario(boolean accesoVoluntario) {
        AccesoVoluntario = accesoVoluntario;
    }

    public boolean isAccesoAdmin() {
        return AccesoAdmin;
    }

    public void setAccesoAdmin(boolean accesoAdmin) {
        AccesoAdmin = accesoAdmin;
    }
}