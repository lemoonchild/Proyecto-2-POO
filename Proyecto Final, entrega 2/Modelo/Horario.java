package Modelo;

public class Horario {
    private Evento evento_reistrado; 
    private Evento [][] matriz_datos_aplicaciones;
    

    public Evento getEvento_reistrado() {
        return evento_reistrado;
    }
    public void setEvento_reistrado(Evento evento_reistrado) {
        this.evento_reistrado = evento_reistrado;
    }
    public Evento[][] getMatriz_datos_aplicaciones() {
        return matriz_datos_aplicaciones;
    }
    public void setMatriz_datos_aplicaciones(Evento[][] matriz_datos_aplicaciones) {
        this.matriz_datos_aplicaciones = matriz_datos_aplicaciones;
    }
}

