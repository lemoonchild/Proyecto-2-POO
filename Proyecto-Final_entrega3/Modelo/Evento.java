/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Guardar la información necesaria de cada evento 
 * creado por el tipo de usuario “Administrador de Evento”. 
 */

package Modelo;

import java.util.*;
public class Evento {
    
    private String eventName; 
    private int hourOfDay;
    private int amountOfUsers;
    private String descriptionEvent;
    private String Fecha;
    private String NombreCreador;
    public ArrayList<Voluntario> VoluntariosInscritos = new ArrayList<Voluntario>();

    

    
    /**
     * @param eventName nombre del evento creado 
     * @param hourOfDay hora del día en el que se desarrollará el evento 
     * @param amountOfUsers cantidad de usuarios por cada evento 
     * @param descriptionEvent pequeña descripcion del evento 
     */
    public Evento(String eventName, int hourOfDay, int amountOfUsers, String descriptionEvent,String Fecha,String NombreCreador) {
        this.eventName = eventName;
        this.hourOfDay = hourOfDay;
        this.amountOfUsers = amountOfUsers;
        this.descriptionEvent = descriptionEvent;
        this.Fecha = Fecha;
        this.NombreCreador = NombreCreador;
    }

    /**
    * Getters y Setters de los atributos del evento  
    */
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public int getHourOfDay() {
        return hourOfDay;
    }
    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }
    public int getAmountOfUsers() {
        return amountOfUsers;
    }
    public void setAmountOfUsers(int amountOfUsers) {
        this.amountOfUsers = amountOfUsers;
    }
    public String getDescriptionEvent() {
        return descriptionEvent;
    }
    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    } 
    

    @Override
    public String toString() {
        String text = ""; 
        text = "\tNombre del evento: " + eventName + "\n\tHorario: " + hourOfDay + "\n\tCantidad total de usuarios: " + amountOfUsers + 
        "\n\tDescripción del usuario: " + descriptionEvent +"\n\tFecha: " +Fecha;
        return text; 
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getNombreCreador() {
        return NombreCreador;
    }

    public void setNombreCreador(String nombreCreador) {
        NombreCreador = nombreCreador;
    }

    public ArrayList<Voluntario> getVoluntariosInscritos() {
        return VoluntariosInscritos;
    }

    public void setVoluntariosInscritos(ArrayList<Voluntario> voluntariosInscritos) {
        VoluntariosInscritos = voluntariosInscritos;
    }

    
}
