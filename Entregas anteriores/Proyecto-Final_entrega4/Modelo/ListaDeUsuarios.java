/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Crear las listas de usuarios que se guardarán dentro del sistema  
 */

package Modelo;

import java.util.ArrayList;

public class ListaDeUsuarios{

    public ArrayList<Administrador_Evento> UsuariosAdministrativos = new ArrayList<Administrador_Evento>();

    public ArrayList<Voluntario> UsuariosVoluntarios = new ArrayList<Voluntario>();
    
    public ArrayList<Administrador_Evento> getUsuariosAdministrativos() {
        return UsuariosAdministrativos;
    }
    public void setUsuariosAdministrativos(ArrayList<Administrador_Evento> usuariosAdministrativos) {
        UsuariosAdministrativos = usuariosAdministrativos;
    }
    public ArrayList<Voluntario> getUsuariosVoluntarios() {
        return UsuariosVoluntarios;
    }
    public void setUsuariosVoluntarios(ArrayList<Voluntario> usuariosVoluntarios) {
        UsuariosVoluntarios = usuariosVoluntarios;
    }

}
