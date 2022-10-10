/**
 * @author Madeline Nahomy Castro Morales 
 * @class Programación Orientada a Objetos 
 * @carnet 22473
 * Proyecto 2 
 * Propósito de la clase: Guardar la información necesaria de cada evento creado por el tipo de usuario “Administrador de Evento”. 
 */


package Model;

public class Evento {
    
    private String eventName; 
    private int hourOfDay;
    private int amountOfUsers;
    private String descriptionEvent;

    
    /**
     * @param eventName nombre del evento creado 
     * @param hourOfDay hora del día en el que se desarrollará el evento 
     * @param amountOfUsers cantidad de usuarios por cada evento 
     * @param descriptionEvent pequeña descripcion del evento 
     */
    public Evento(String eventName, int hourOfDay, int amountOfUsers, String descriptionEvent) {
        this.eventName = eventName;
        this.hourOfDay = hourOfDay;
        this.amountOfUsers = amountOfUsers;
        this.descriptionEvent = descriptionEvent;
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
        "\n\tDescripción del usuario: " + descriptionEvent; 
        return text; 
    }
}
