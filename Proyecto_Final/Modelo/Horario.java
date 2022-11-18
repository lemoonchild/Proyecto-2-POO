/**
 * @class Programación Orientada a Objetos 
 * Proyecto 2 
 * Propósito de la clase: Esta clase va a estar ligada con la clase Usuario, cada usuario tendrá su 
 * propio horario que será modificado dependiendo de la información que esté agregue.
 */

package Modelo;

import java.io.Serializable;
import java.util.*;

import Vista.vista;

public class Horario implements Serializable {
    String Nombre;
    int numerito;
    private Evento evento_reistrado;
    public ArrayList<Evento> CreadosRecientemente = new ArrayList<Evento>();
    public ArrayList<Evento> Horarios = new ArrayList<Evento>();

    public void PublicarHorario(vista vista1) {
        int x = CreadosRecientemente.size();
        if (x != 0) {
            for (int i = 0; i <= CreadosRecientemente.size() - 1; i++) {
                Horarios.add(CreadosRecientemente.get(i));
                CreadosRecientemente.remove(i);
            }
            vista1.MostrarMensaje("Se han publicado correctamente tu  eventos al horario general-");
        }
        if (x == 0) {
            vista1.MostrarMensaje("No has creado un evento para publicar");
        }

    }

    public void Asignarse(ListaDeUsuarios listaDeUsuarios1, vista vista1) {
        if (Horarios.size() != 0) {
            for (int l = 0; l <= Horarios.size() - 1; l++) {
                vista1.MostrarMensaje("\nEvento Numero: " + l + ".");
                vista1.MostrarMensaje("Nombre Del Evento: " + Horarios.get(l).getEventName());
                vista1.MostrarMensaje("Horas de duracion del evento: " + Horarios.get(l).getHourOfDay());
                vista1.MostrarMensaje("Descripcion Del Evento: " + Horarios.get(l).getDescriptionEvent());
                vista1.MostrarMensaje("Fecha del evento: " + Horarios.get(l).getFecha());
            }
            int asig = vista1.Asignarse();
            for (int h = 0; h <= listaDeUsuarios1.UsuariosVoluntarios.size() - 1; h++) {
                if (vista1.NombreTemporal.equals(listaDeUsuarios1.UsuariosVoluntarios.get(h).username)) {
                    listaDeUsuarios1.UsuariosVoluntarios.get(h).EventosAsignados.add(Horarios.get(asig));
                    int temporal = Horarios.get(asig).getAmountOfUsers() + 1;
                    Horarios.get(asig).setAmountOfUsers(temporal);
                    vista1.MostrarMensaje("Te has Asignado de manera exitosa.");
                }
            }
        }

    }

    public void VerEventosCreador(vista vista1) {
        if (Horarios.size() != 0) {
            for (int p = 0; p <= Horarios.size() - 1; p++) {
                if (Horarios.get(p).getNombreCreador().equals(vista1.NombreTemporal)) {
                    vista1.MostrarMensaje("\nNombre Del Evento: " + Horarios.get(p).getEventName());
                    vista1.MostrarMensaje("Horas de duracion del evento: " + Horarios.get(p).getHourOfDay());
                    vista1.MostrarMensaje("Usuarios Inscritos: " + Horarios.get(p).getAmountOfUsers());
                    vista1.MostrarMensaje("Descripcion Del Evento: " + Horarios.get(p).getDescriptionEvent());
                    vista1.MostrarMensaje("Fecha del evento: " + Horarios.get(p).getFecha());
                    if (Horarios.get(p).VoluntariosInscritos.size() != 0) {
                        vista1.MostrarMensaje("Nombre de personas inscritas:");
                        for (int m = 0; m <= Horarios.get(p).VoluntariosInscritos.size() - 1; m++) {
                            System.out.println(Horarios.get(p).VoluntariosInscritos.get(m).username);
                            System.out.println(Horarios.get(p).VoluntariosInscritos.get(m).getNumeroDeTelefono());
                        }
                    }
                }
                if (!Horarios.get(p).getNombreCreador().equals(vista1.NombreTemporal)) {
                    numerito++;
                }
                if (numerito == Horarios.size()) {
                    vista1.MostrarMensaje("No existe ningun evento creado por ti");
                }
            }
        }
        if (Horarios.size() == 0) {
            vista1.MostrarMensaje("ERROR: No existe ningun evento en el horario");
        }
    }

    public void VerHorarioAsignados(vista vista1, ListaDeUsuarios listaDeUsuarios1) {
        for (int y = 0; y <= listaDeUsuarios1.UsuariosVoluntarios.size() - 1; y++) {
            if (vista1.NombreTemporal.equals(listaDeUsuarios1.UsuariosVoluntarios.get(y).username)) {
                if (listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados.size() != 0) {
                    for (int b = 0; b <= listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados.size() - 1; b++) {
                        System.out.println("\nNombre Evento: "
                                + listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados.get(b).getEventName());
                        System.out.println("Fecha: "
                                + listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados.get(b).getFecha());
                        System.out.println(
                                "Descripcion Evento: " + listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados
                                        .get(b).getDescriptionEvent());
                        System.out.println("Fecha Evento: "
                                + listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados.get(b).getFecha());
                    }
                }
                if (listaDeUsuarios1.UsuariosVoluntarios.get(y).EventosAsignados.size() == 0) {
                    vista1.MostrarMensaje("No te has inscrito a ningun evento");
                }
            }
        }

    }

    public void EliminarHorario(vista vista1){
        vista1.MostrarMensaje("Esta funcion eliminara todos los eventos que tengas en tu horario personal");
        vista1.MostrarMensaje("Estas Seguro Que quieres continuar? 1. Si, 2. No");
        int Respuesta = vista1.Eliminar();
        if(Respuesta == 1){
            for(int e = 0; e <= CreadosRecientemente.size()-1;e++){
                CreadosRecientemente.remove(e);
            }
            vista1.MostrarMensaje("Se han eliminado correctamente todos los eventos en tu horario personal");
            vista1.MostrarMensaje("Recuerda  que al registrar un horario, este no se podra quitar a menos que se hable con un desarrollador.");
        }
        
    }

    public Evento getEvento_reistrado() {
        return evento_reistrado;
    }

    public void setEvento_reistrado(Evento evento_reistrado) {
        this.evento_reistrado = evento_reistrado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
