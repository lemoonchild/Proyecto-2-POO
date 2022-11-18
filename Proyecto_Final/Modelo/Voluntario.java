/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Clase dependiente de usuario, cuenta con los datos necesarios de aquellos que 
 * buscan apoyar en algún evento. Permite crear nuevos objetos de este tipo registrando lo requerido. 
 */

package Modelo;
import java.util.*;

public class Voluntario extends Usuario {

    private int NumeroDeTelefono;
    private String NombrePersona;
    public ArrayList<Evento> EventosAsignados = new ArrayList<Evento>();

    public Voluntario(String username, String password, int dPI, boolean typeUser, int numeroTelefono, String nombrePersona) {
        super(username, password, dPI, typeUser);
        
        this.NumeroDeTelefono = numeroTelefono;
        this.NombrePersona = nombrePersona;
        
    }
    public int getNumeroDeTelefono() {
        return NumeroDeTelefono;
    }
    public void setNumeroDeTelefono(int numeroDeTelefono) {
        NumeroDeTelefono = numeroDeTelefono;
    }
    public String getNombrePersona() {
        return NombrePersona;
    }
    public void setNombrePersona(String nombrePersona) {
        NombrePersona = nombrePersona;
    }
    public ArrayList<Evento> getEventosAsignados() {
        return EventosAsignados;
    }
    public void setEventosAsignados(ArrayList<Evento> eventosAsignados) {
        EventosAsignados = eventosAsignados;
    }
    
}

