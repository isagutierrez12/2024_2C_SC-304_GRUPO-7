package proyectofinal;

import java.util.Date;

public class Evento {
    private String nombre;
    private Date fecha;
    private String ubicacion;
    private NodoParticipante cabezaParticipantes;

    // Constructor de la clase Evento
    public Evento(String nombre, Date fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cabezaParticipantes = null; // No hay participantes al inicio
    }

    // Métodos getter y setter para los atributos del evento
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

    public NodoParticipante getCabezaParticipantes() {
        return cabezaParticipantes;
    }

    public void setCabezaParticipantes(NodoParticipante cabezaParticipantes) {
        this.cabezaParticipantes = cabezaParticipantes;
    }

    // Método para actualizar los detalles del evento
    public void actualizarInformacion(String nuevoNombre, Date nuevaFecha, String nuevaUbicacion) {
        this.nombre = nuevoNombre;
        this.fecha = nuevaFecha;
        this.ubicacion = nuevaUbicacion;
    }

    // Método para añadir un participante al evento
    public void agregarParticipante(Participante participante) {
        NodoParticipante nuevoNodo = new NodoParticipante(participante);
        if (cabezaParticipantes == null) {
            cabezaParticipantes = nuevoNodo;
        } else {
            NodoParticipante actual = cabezaParticipantes;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
        }
    }

    // Método para eliminar un participante del evento
    public void eliminarParticipante(String nombreParticipante) {
        NodoParticipante actual = cabezaParticipantes;
        while (actual != null) {
            if (actual.getParticipante().getNombre().equals(nombreParticipante)) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    cabezaParticipantes = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha + ", Ubicación: " + ubicacion;
    }
}
