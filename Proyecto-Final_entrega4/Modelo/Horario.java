/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Esta clase va a estar ligada con la clase Usuario, cada usuario tendrá su 
 * propio horario que será modificado dependiendo de la información que esté agregue.
 */

package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Horario implements Serializable {
    String Nombre;
    private Evento evento_reistrado;
    ArrayList<ArrayList<ArrayList<Evento>>> Horario = new ArrayList<ArrayList<ArrayList<Evento>>>();

    public void CrearHorario() {
        // Creacion de Dias
        ArrayList<ArrayList<Evento>> Lunes = new ArrayList<ArrayList<Evento>>();
        ArrayList<ArrayList<Evento>> Martes = new ArrayList<ArrayList<Evento>>();
        ArrayList<ArrayList<Evento>> Miercoles = new ArrayList<ArrayList<Evento>>();
        ArrayList<ArrayList<Evento>> Jueves = new ArrayList<ArrayList<Evento>>();
        ArrayList<ArrayList<Evento>> Viernes = new ArrayList<ArrayList<Evento>>();
        // Creacion De bloques Lunes
        ArrayList<Evento> Bloque1 = new ArrayList<Evento>();
        Lunes.add(Bloque1);
        Martes.add(Bloque1);
        Miercoles.add(Bloque1);
        Jueves.add(Bloque1);
        Viernes.add(Bloque1);
        // Creacion De Bloques Martes
        ArrayList<Evento> Bloque2 = new ArrayList<Evento>();
        Lunes.add(Bloque2);
        Martes.add(Bloque2);
        Miercoles.add(Bloque2);
        Jueves.add(Bloque2);
        Viernes.add(Bloque2);
        // Creacion de Bloques Miercoles
        ArrayList<Evento> Bloque3 = new ArrayList<Evento>();
        Lunes.add(Bloque3);
        Martes.add(Bloque3);
        Miercoles.add(Bloque3);
        Jueves.add(Bloque3);
        Viernes.add(Bloque3);
        // Creacion De bloques Jueves
        ArrayList<Evento> Bloque4 = new ArrayList<Evento>();
        Lunes.add(Bloque4);
        Martes.add(Bloque4);
        Miercoles.add(Bloque4);
        Jueves.add(Bloque4);
        Viernes.add(Bloque4);
        // Creacion De Bloques Viernes
        ArrayList<Evento> Bloque5 = new ArrayList<Evento>();
        Lunes.add(Bloque5);
        Martes.add(Bloque5);
        Miercoles.add(Bloque5);
        Jueves.add(Bloque5);
        Viernes.add(Bloque5);
        // Creacion De Bloques Sabado
        ArrayList<Evento> Bloque6 = new ArrayList<Evento>();
        Lunes.add(Bloque6);
        Martes.add(Bloque6);
        Miercoles.add(Bloque6);
        Jueves.add(Bloque6);
        Viernes.add(Bloque6);
        // Agregar Dias a horario
        Horario.add(Lunes);
        Horario.add(Martes);
        Horario.add(Miercoles);
        Horario.add(Jueves);
        Horario.add(Viernes);
    }

    public Evento getEvento_reistrado() {
        return evento_reistrado;
    }

    public void setEvento_reistrado(Evento evento_reistrado) {
        this.evento_reistrado = evento_reistrado;
    }

}
