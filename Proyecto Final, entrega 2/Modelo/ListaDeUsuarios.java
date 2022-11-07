/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Esta clase va a estar ligada con la clase Usuario, cada usuario tendrá su 
 * propio horario que será modificado dependiendo de la información que esté agregue.
 */

package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaDeUsuarios implements Serializable {
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
