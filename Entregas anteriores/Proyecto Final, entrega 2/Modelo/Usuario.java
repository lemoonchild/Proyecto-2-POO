/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Clase padre de los distintos tipos de usuarios que podrán ingresar al programa con el propósito de registrarse a 
 * una actividad o ser anfitriones de una. Permite guardar la información básica de cada usuario ingresado.
 */
package Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    protected String username;
    protected String password;
    protected int DPI;
    protected boolean typeUser;

    /**
     * @param username nombre de usuario
     * @param password contraseña del usuario
     * @param dPI      documento de identificacion del usuario
     * @param typeUser tipo de usuario ingresado = false/admin evento true/voluntario
     */
    public Usuario(String username, String password, int dPI, boolean typeUser) {
        this.username = username;
        this.password = password;
        DPI = dPI;
        this.typeUser = typeUser;
    }
    
    /**
     * Getters y Setters de los atributos del usuario
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int dPI) {
        DPI = dPI;
    }

    public boolean isTypeUser() {
        return typeUser;
    }

    public void setTypeUser(boolean typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        String text = "";
        text = "\tNombre de usuario: " + username + "\n\tDocumento de Identificacion: " + DPI;
        return text;
    }

}
