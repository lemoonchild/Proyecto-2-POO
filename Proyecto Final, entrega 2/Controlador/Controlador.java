/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Hace la logística del programa 
 */

package Controlador;

import Modelo.Administrador_Evento;
import Modelo.ListaDeUsuarios;
import Modelo.Voluntario;
import Vista.vista;

public class Controlador {
    
    boolean ciclo = true;

     public void IniciarPrograma(vista vista1){

        ListaDeUsuarios listaDeUsuarios1 = new ListaDeUsuarios();
        while(ciclo == true){
            int decidido = vista1.Inicio();
            if(decidido == 1 ){ //Registrarse
                crear_usuario(vista1, listaDeUsuarios1);
            }
            else if(decidido == 2){ //Inicio de sesión
                vista1.IniciarSesion(listaDeUsuarios1);
                if(vista1.AccesoAdmin == true || vista1.AccesoVoluntario == true){
                    vista1.Menu();
                }
            }
            else { //Salir
                ciclo = false;
            }

        }
    }
    public void crear_usuario(vista vista1,ListaDeUsuarios listaDeUsuarios1){

        int tipoUsuario = vista1.TipoDeUsuarioCreado();
        
        if(tipoUsuario == 1){
            Voluntario voluntario1 = new Voluntario("", "", 0, false, 0, "");
            vista1.CrearUsuarioVoluntario(voluntario1);
            listaDeUsuarios1.UsuariosVoluntarios.add(voluntario1);
        }
        else if(tipoUsuario== 2){

            Administrador_Evento admin1 = new Administrador_Evento("", "", 0, false, 0, "");
            vista1.CrearUsuarioAdmin(admin1);
            listaDeUsuarios1.UsuariosAdministrativos.add(admin1);
        }
        
    }

}
