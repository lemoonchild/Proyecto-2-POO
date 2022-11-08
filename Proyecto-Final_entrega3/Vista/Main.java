/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Permite que se ejecute el código a dentro de las distintas clases
 */

package Vista;

import java.io.File;

import Controlador.Controlador;
import Modelo.ListaDeUsuarios;

public class Main {
    public static void main(String[] args) throws Exception {

        vista vista1 = new vista();
        Controlador controlador1 = new Controlador();
        // controlador1.IniciarPrograma(vista1);
        controlador1.AbrirDoc(new File("vol.txt"), new File("admin.txt"), new ListaDeUsuarios());

    }
}