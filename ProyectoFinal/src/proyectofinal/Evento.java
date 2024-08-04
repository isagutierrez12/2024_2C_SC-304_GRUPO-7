package proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Evento {
    private String nombre;
    private Date fecha;
    private String ubicacion;
    private LinkedList<Participante> listaParticipantes;
    private ColaPartidos colaPartidos; // Añadido para gestionar partidos

    public Evento(String nombre, Date fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.listaParticipantes = new LinkedList<>();
        this.colaPartidos = new ColaPartidos(); // Inicialización de la cola de partidos
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Evento: " + nombre + ", Fecha: " + sdf.format(fecha) + ", Ubicación: " + ubicacion;
    }

    // Métodos para gestionar partidos
    public void mostrarCalendarioPartidos() {
        String calendario = colaPartidos.calendarioEvento(this);
        if (calendario.isEmpty()) {
            System.out.println("No hay partidos programados para este evento.");
        } else {
            System.out.println("Calendario de Partidos para " + nombre + ":");
            System.out.println(calendario);
        }
    }

    public void programarPartido(Partido partido) {
        colaPartidos.enCola(partido);
    }
}
