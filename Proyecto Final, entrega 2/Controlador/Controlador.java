package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Modelo.Administrador_Evento;
import Modelo.ListaDeUsuarios;
import Modelo.Usuario;
import Modelo.Voluntario;
import Vista.vista;

public class Controlador {
    File doc_voluntarios = new File("voluntarios.txt");
    File doc_administradores = new File("voluntarios.txt");

    boolean ciclo = true;

    public void IniciarPrograma(vista vista1) throws Exception {

        ListaDeUsuarios listaDeUsuarios1 = new ListaDeUsuarios();
        AbrirDoc(doc_voluntarios, doc_administradores, listaDeUsuarios1);
        while (ciclo == true) {
            int decidido = vista1.Inicio();
            if (decidido == 1) { // Registrarse
                crear_usuario(vista1, listaDeUsuarios1);
            } else if (decidido == 2) { // Inicio de sesión
                vista1.IniciarSecion(listaDeUsuarios1);
                if (vista1.AccesoAdmin == true || vista1.AccesoVoluntario == true) {
                    vista1.Menu();
                }
            } else { // Salir
                ciclo = false;
            }

        }
    }

    public void crear_usuario(vista vista1, ListaDeUsuarios listaDeUsuarios1) {
        vista1.TipoDeUsuarioCreado();

        if (vista1.RespuestaI == 1) {
            Voluntario voluntario1 = new Voluntario();
            vista1.CrearUsuarioVoluntario(voluntario1);
            listaDeUsuarios1.UsuariosVoluntarios.add(voluntario1);
        } else if (vista1.RespuestaI == 2) {
            Administrador_Evento admin1 = new Administrador_Evento();
            vista1.CrearUsuarioAdmin(admin1);
            listaDeUsuarios1.UsuariosAdministrativos.add(admin1);
        }

    }

    public void Iniciar_Sesión(Administrador_Evento admin1, vista vista1) {

    }

    public void Cerrar_Sesión() {
    }

    public void Revisar_Usuario_y_Contraseña() {

    }

    public void Crear_Evento() {

    }

    public void Buscar_Eventos() {

    }

    public void Asignar_evento() {

    }

    public void Crear_Horario() {

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
     * 
     * @param doc
     * @throws Exception
     */
    public void AbrirDoc(File docA, File docV, ListaDeUsuarios lDeUsuarios) throws Exception {
        try {
            if (docA.createNewFile()) {
                System.out.println("Se ha creado: " + docA.getName());
            }
            if (docV.createNewFile()) {
                System.out.println("Se ha creado: " + docV.getName());
            } else { // Leer datos si el archivo existe
                LeerDatos(docV, docA, lDeUsuarios);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
