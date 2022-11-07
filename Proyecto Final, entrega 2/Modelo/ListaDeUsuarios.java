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
