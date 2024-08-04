package proyectofinal;

import java.util.Date;

public class Partido {
    private Evento evento;
    private String equipo1;
    private String equipo2;
    private Date fecha;
    private Partido siguiente; // Referencia al siguiente partido en la cola

    public Partido(Evento evento, String equipo1, String equipo2, Date fecha) {
        this.evento = evento;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.siguiente = null; // Inicialmente no hay siguiente partido
    }

    // Métodos para obtener y establecer la información del partido
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Partido getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Partido siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Partido: " + equipo1 + " vs " + equipo2 + ", Fecha: " + fecha;
    }
}
