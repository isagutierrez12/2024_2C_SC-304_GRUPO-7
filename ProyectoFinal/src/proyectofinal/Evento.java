package proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Evento {
    private String nombre;
    private Date fecha;
    private String ubicacion;
    private LinkedList<Participante> listaParticipantes;

    public Evento(String nombre, Date fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.listaParticipantes = new LinkedList<>();
    }

    // Métodos para gestionar participantes
    public void agregarParticipante(Participante p) {
        listaParticipantes.add(p);
    }

    public void eliminarParticipante(Participante p) {
        listaParticipantes.remove(p);
    }

    public LinkedList<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    // Métodos para actualizar información del evento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha + ", Ubicación: " + ubicacion;
    }

    void mostrarCalendarioPartidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void programarPartido(Partido partido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
