/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Clase dependiente de usuario, cuenta con los datos necesarios de aquellos que 
 * buscan apoyar en algún evento. Permite crear nuevos objetos de este tipo registrando lo requerido. 
 */

package Modelo;

public class Voluntario extends Usuario {
    
    private String NumeroDeTelefono;
    private String NombrePersona;

    public Voluntario(String username, String password, int dPI, boolean typeUser, int numeroTelefono, String nombrePersona) {
        super(username, password, dPI, typeUser);
        this.NumeroDeTelefono = numeroTelefono;
        this.NombrePersona = nombrePersona;
        
    }
    public String getNumeroDeTelefono() {
        return NumeroDeTelefono;
    }
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        NumeroDeTelefono = numeroDeTelefono;
    }
    public String getNombrePersona() {
        return NombrePersona;
    }
    public void setNombrePersona(String nombrePersona) {
        NombrePersona = nombrePersona;
    }
}

