/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Clase dependiente de usuario, cuenta con los datos necesarios para crear un 
 * evento nuevo. Permite crear nuevos objetos de este tipo registrando lo requerido.
 */

package Modelo;
import java.util.*;

public class Administrador_Evento extends Usuario {
    
    private int NumeroDeTelefono;
    private String NombrePersona;
    public ArrayList<Evento> eventosCreados = new ArrayList<Evento>();
    
    public Administrador_Evento(String username, String password, int dPI, boolean typeUser, int numeroDeTelefono, String nombrePersona) {
        super(username, password, dPI, typeUser);

        this.NumeroDeTelefono = numeroDeTelefono;
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
    


    
}

