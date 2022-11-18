/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Hace la logística del programa 
 */

package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Modelo.Administrador_Evento;
import Modelo.Evento;
import Modelo.Horario;
import Modelo.ListaDeUsuarios;
import Modelo.Voluntario;
import Vista.vista;

public class Controlador {
    File doc_voluntarios = new File("voluntarios.txt");
    File doc_administradores = new File("voluntarios.txt");
    File doc_horarios = new File("horarios.txt");
    boolean ciclo = true;

    public void IniciarPrograma(vista vista1) throws Exception {

        ListaDeUsuarios listaDeUsuarios1 = new ListaDeUsuarios();
        AbrirDoc(doc_voluntarios, doc_administradores, listaDeUsuarios1);

        Horario.CrearHorario();
        AbrirHorarios(doc_horarios, Horario.Horario);

        while (ciclo == true) {
            int decidido = vista1.Inicio();
            if (decidido == 1) { // Registrarse
                crear_usuario(vista1, listaDeUsuarios1);
            } else if (decidido == 2) { // Inicio de sesión
                vista1.IniciarSesion(listaDeUsuarios1);
                if (vista1.AccesoAdmin == true || vista1.AccesoVoluntario == true) {
                    Boolean ciclo1 = true;
                    while (ciclo1) {

                        int menuP = vista1.Menu();
                        if (menuP == 1) { // Registrar horario
                            vista1.MostrarMensaje("Función en proceso...");

                        } else if (menuP == 2) { // Asignarse a un voluntariado
                            vista1.MostrarMensaje("Función en proceso...");

                        } else if (menuP == 3) { // Crear un nuevo programa de apoyo
                            vista1.menuEvento();

                        } else if (menuP == 4) { // Ver horarios asignados
                            vista1.MostrarMensaje("Función en proceso...");

                        } else if (menuP == 5) { // Salir
                            ciclo1 = false;
                        } else {
                            vista1.MostrarMensaje("Cuidado, escoge una opción del 1 al 5\n");
                        }

                    }
                }

            } else { // Salir
                GuardarDatos(doc_voluntarios, doc_administradores, listaDeUsuarios1);
                GuardarHorario(doc_horarios, Horario.Horario);
                ciclo = false;
            }

        }
    }

    public void crear_usuario(vista vista1, ListaDeUsuarios listaDeUsuarios1) {

        int tipoUsuario = vista1.TipoDeUsuarioCreado();

        if (tipoUsuario == 1) {
            Voluntario voluntario1 = new Voluntario("", "", 0, false, 0, "");
            vista1.CrearUsuarioVoluntario(voluntario1);
            listaDeUsuarios1.UsuariosVoluntarios.add(voluntario1);
        } else if (tipoUsuario == 2) {

            Administrador_Evento admin1 = new Administrador_Evento("", "", 0, false, 0, "");
            vista1.CrearUsuarioAdmin(admin1);
            listaDeUsuarios1.UsuariosAdministrativos.add(admin1);
        }

    }

    /**
     * Utiliza las funciones en serializar para leer los datos del documento dado.
     * 
     * @param docV      documento que registra todos los usuarios de voluntarios
     * @param docA      documento que registra todos los usuarios de administradores
     * @param lUsuarios instancia de clase lista de usuarios, encargada de guardar
     *                  los datos
     */
    public void LeerDatos(File docV, File docA, ListaDeUsuarios lUsuarios) {
        if (lUsuarios != null) {
            try {
                lUsuarios.setUsuariosVoluntarios(Serializar.leer(docV));
                lUsuarios.setUsuariosAdministrativos(Serializar.leer(docA));
            } catch (IOException e) {
                lUsuarios.setUsuariosVoluntarios(new ArrayList<Voluntario>());
                lUsuarios.setUsuariosAdministrativos(new ArrayList<Administrador_Evento>());
            } catch (ClassNotFoundException e) {

            } catch (java.lang.NullPointerException e) {

            }
        }

    }

    /**
     * Utiliza la función en serializar para guardar, los datos recibidos, en un
     * documento.
     * 
     * @param <tipo> puede guardar cualquier tipo de dato
     * @param docV   documento donde se guardan los datos de voluntarios
     * @param docA   donde se guardan los datos de administradores
     * @param objeto lo que se guardaría
     */
    public <tipo> void GuardarDatos(File docV, File docA, ListaDeUsuarios lUsuarios) {
        vista view = new vista();
        try {
            @SuppressWarnings("unchecked")
            tipo objeto1 = (tipo) lUsuarios.getUsuariosAdministrativos();
            Serializar.escribir(docA, objeto1);

            @SuppressWarnings("unchecked")
            tipo objeto2 = (tipo) lUsuarios.getUsuariosVoluntarios();
            Serializar.escribir(docV, objeto2);

            view.MostrarMensaje("Datos guardados en " + docV.getName() + " y " + docA.getName()
                    + "\n Podrán usarse la próxima vez que ingreses al programa.");

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo archivo o lee los datos del que fue creado antes.
     * ~~Puede cambiar en las siguientes versiones según sea necesario~~
     * 
     * @param docV        voluntarios registrados
     * @param docA        administradores registrados
     * @param lDeUsuarios instancia de la clase ListaDeUsuarios para tener control
     *                    del registro
     * @throws Exception
     */
    public void AbrirDoc(File docV, File docA, ListaDeUsuarios lDeUsuarios) throws Exception {
        vista view = new vista();
        Boolean nuevo_admin = docA.createNewFile();
        Boolean nuevo_vol = docV.createNewFile();

        if (nuevo_admin && nuevo_vol) { // Ambos archivos son creados
            view.MostrarMensaje("Se ha creado: " + docA.getName() + " y " + docV.getName());
        } else if (!nuevo_vol && nuevo_admin) { // Se crea un nuevo archivo de administradores
            view.MostrarMensaje("Se ha creado: " + docA.getName());
            LeerDatos(docV, docA, lDeUsuarios); // se leen los datos del archivo de voluntarios
        } else if (!nuevo_admin && nuevo_vol) { // Se crea un nuevo archivo de voluntarios
            view.MostrarMensaje("Se ha creado: " + docV.getName());
            LeerDatos(docV, docA, lDeUsuarios); // se leen los datos del archivo de administradores
        } else { // Leer datos si ambos archivo existe
            LeerDatos(docV, docA, lDeUsuarios);
            view.MostrarMensaje("Se han leído los datos de: " + docA.getName() + " y " + docV.getName());
        }

    }

    /**
     * Crea un nuevo archivo o lee los datos del que fue creado antes.
     * 
     * @param doc
     * @throws Exception
     */
    public void AbrirHorarios(File docH, ArrayList<ArrayList<ArrayList<Evento>>> horarios) throws Exception {
        try {
            if (docH.createNewFile()) {
                System.out.println("Se ha creado: " + docH.getName());
            } else { // Leer datos si el archivo existe
                LeerDatos_Horario(docH, horarios);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Utiliza las funciones en serializar para leer los datos del documento dado.
     * 
     * @param doc
     */
    public void LeerDatos_Horario(File doc, ArrayList<ArrayList<ArrayList<Evento>>> horario) {
        try {
            horario = Serializar.leer(doc);
        } catch (IOException e) {
            // horario = new Horario();
        } catch (ClassNotFoundException e) {

        }
    }

    /**
     * Utiliza la función en serializar para guardar, los datos recibidos, en un
     * documento.
     * 
     * @param <tipo>
     * @param documento
     * @param objeto
     */
    public <tipo> void GuardarHorario(File documento, ArrayList<ArrayList<ArrayList<Evento>>> horario) {
        try {
            @SuppressWarnings("unchecked")
            tipo objeto = (tipo) horario;
            Serializar.escribir(documento, objeto);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param evento Ingresa el evento creado y lo asigna según al horario deseado
     */
    public void asignarEvento(Evento evento) {

        // ArrayList Horario
        for (int i = 0; i < Horario.Horario.size(); i++) { // Acceder a los días de la semana
            int posicion = evento.getHourOfDay();
            for (int j = 0; j < Horario.Horario.get(posicion).size(); j++) {// Acceder a los horarios correspondientes a
                                                                            // cada día
                int bloqueHorario = evento.getBloqueTiempo();
                for (int k = 0; k < Horario.Horario.get(posicion).get(bloqueHorario).size(); k++) { // Acceder a los
                                                                                                    // eventos
                                                                                                    // correspondientes
                                                                                                    // a los horarios
                                                                                                    // del día
                    Horario.Horario.get(posicion).get(bloqueHorario).add(evento);

                }
            }
        }

    }
}
