package Modelo;

public class Voluntario extends Usuario {
    private String NumeroDeTelefono;
    private String NombrePersona;

    public void CrearEvento(){
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

