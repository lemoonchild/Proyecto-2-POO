/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Permite que se ejecute el código a dentro de las distintas clases
 */

package Vista;

import Controlador.Controlador;

public class Main {
    public static void main(String[] args) throws Exception {

        vista vista1 = new vista();
        Controlador controlador1 = new Controlador();
        controlador1.IniciarPrograma(vista1);

    }
}