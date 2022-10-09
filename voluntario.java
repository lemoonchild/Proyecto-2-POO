/**
 * Integrante: Fabiola Contreras 22787
 * 
 * voluntario: permite crear nuevos objetos de este tipo, lo que da acceso al
 * registro de datos de nuevas personas que desean aportar en algún
 * voluntariado.
 */
public class voluntario {
    private String Nombre;
    private String Documento_Identificacion;

    public voluntario(String nombre, String documento_Identificacion) {
        Nombre = nombre;
        Documento_Identificacion = documento_Identificacion;
    }

    public String getDocumento_Identificacion() {
        return Documento_Identificacion;
    }

    public void setDocumento_Identificacion(String documento_Identificacion) {
        Documento_Identificacion = documento_Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
