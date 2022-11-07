package Vista;
import Controlador.Controlador;
public class Main {
    public static void main (String [ ] args) {
        //Un nuevo objeto tipo vista cuyo nombre es vista 1
        vista vista1 = new vista();
        Controlador controlador1 = new Controlador();
        controlador1.IniciarPrograma(vista1);
        

        //AQUI VA EL CONTROLADOR



    }
}