/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Guardar la información necesaria de cada evento 
 * creado por el tipo de usuario “Administrador de Evento”. 
 */

package Modelo;

public class Evento {
    
    private String eventName; 
    private int hourOfDay;
    private int amountOfUsers;
    private String descriptionEvent;
    private int bloqueTiempo; 

    /**
     * @param eventName nombre del evento creado 
     * @param hourOfDay hora del día en el que se desarrollará el evento 
     * @param amountOfUsers cantidad de usuarios por cada evento 
     * @param descriptionEvent pequeña descripcion del evento 
     */
    public Evento(String eventName, int hourOfDay, int amountOfUsers, String descriptionEvent, int bloqueTiempo) {
        this.eventName = eventName;
        this.hourOfDay = hourOfDay;
        this.amountOfUsers = amountOfUsers;
        this.descriptionEvent = descriptionEvent;
        this.bloqueTiempo = bloqueTiempo;
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
    public int getBloqueTiempo() {
        return bloqueTiempo;
    }
    public void setBloqueTiempo(int bloqueTiempo) {
        this.bloqueTiempo = bloqueTiempo;
    }
    @Override
    public String toString() {
        String text = ""; 
        text = "\tNombre del evento: " + eventName + "\n\tHorario: " + hourOfDay + "\n\tCantidad total de usuarios: " + amountOfUsers + 
        "\n\tDescripción del usuario: " + descriptionEvent; 
        return text; 
    }
}
