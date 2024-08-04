package proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {
    private String nombre;
    private Date fecha;
    private String ubicacion;
    private NodoParticipante cabezaParticipantes;
    private NodoParticipante colaParticipantes;
    private int numParticipantes;

    public Evento(String nombre, Date fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cabezaParticipantes = null;
        this.colaParticipantes = null;
        this.numParticipantes = 0;
    }

    // Métodos para gestionar participantes
    public void agregarParticipante(Participante p) {
        NodoParticipante nuevoNodo = new NodoParticipante(p);
        if (cabezaParticipantes == null) {
            cabezaParticipantes = nuevoNodo;
            colaParticipantes = nuevoNodo;
        } else {
            colaParticipantes.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(colaParticipantes);
            colaParticipantes = nuevoNodo;
        }
        numParticipantes++;
    }

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
                } else {
                    colaParticipantes = actual.getAnterior();
                }
                numParticipantes--;
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public NodoParticipante getCabezaParticipantes() {
        return cabezaParticipantes;
    }

    // Métodos para actualizar información del evento
    public void actualizarInformacion(String nuevoNombre, Date nuevaFecha, String nuevaUbicacion) {
        this.nombre = nuevoNombre;
        this.fecha = nuevaFecha;
        this.ubicacion = nuevaUbicacion;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Evento: " + nombre + ", Fecha: " + sdf.format(fecha) + ", Ubicación: " + ubicacion;
    }

    public void mostrarCalendarioPartidos() {
        // Implementar según sea necesario
    }

    public void programarPartido(Partido partido) {
        // Implementar según sea necesario
    }

    // NodoParticipante como clase interna
    private class NodoParticipante {
        private Participante participante;
        private NodoParticipante siguiente;
        private NodoParticipante anterior;

        public NodoParticipante(Participante participante) {
            this.participante = participante;
            this.siguiente = null;
            this.anterior = null;
        }

        public Participante getParticipante() {
            return participante;
        }

        public void setParticipante(Participante participante) {
            this.participante = participante;
        }

        public NodoParticipante getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoParticipante siguiente) {
            this.siguiente = siguiente;
        }

        public NodoParticipante getAnterior() {
            return anterior;
        }

        public void setAnterior(NodoParticipante anterior) {
            this.anterior = anterior;
        }
    }
}
