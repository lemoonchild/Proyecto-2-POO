package Controlador;
/*
 * 
 * Clase serializar
 * Establece funciones para guardar y recabar datos desde un archivo.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Serializar {
    /**
     * Haciendo uso de File, guarda los datos del cierto objeto en un documento
     * establecido.
     * Los guarda en el formato necesario para que la puedan volver a leerse
     * después.
     * 
     * @param <T>
     * @param donde
     * @param que
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> void escribir(File donde, T que) throws IOException, ClassNotFoundException {
        FileOutputStream escritor = new FileOutputStream(donde); // Ubica el archivo donde guardar los datos
        try (ObjectOutputStream objeto = new ObjectOutputStream(escritor)) { // Escribe los datos como stream en el
                                                                             // archivo.
            objeto.writeObject(que);
        }
    }

    /**
     * Revisa el documento dado y vuelve a cargar los datos que fueron guardados
     * ahí.
     * 
     * @param <tipo>
     * @param Porleer
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <tipo> tipo leer(File Porleer) throws IOException, ClassNotFoundException {
        FileInputStream lector = new FileInputStream(Porleer); // Convierte los datos en el documento a un stream.
        try (ObjectInputStream leedor = new ObjectInputStream(lector)) { // Recibe los datos del stream
            @SuppressWarnings("unchecked")
            tipo objeto = (tipo) leedor.readObject(); // Los guarda nuevamente como objetos
            return objeto;
        }
    }

}