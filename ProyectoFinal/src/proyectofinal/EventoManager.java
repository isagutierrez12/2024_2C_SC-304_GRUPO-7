package proyectofinal;

import java.util.Date;

public class EventoManager {
    private NodoEvento cabezaEventos;

    public EventoManager() {
        cabezaEventos = null;
    }

    public void registrarEvento(String nombre, Date fecha, String ubicacion) {
        Evento evento = new Evento(nombre, fecha, ubicacion);
        NodoEvento nuevoNodo = new NodoEvento(evento);
        if (cabezaEventos == null) {
            cabezaEventos = nuevoNodo;
        } else {
            NodoEvento actual = cabezaEventos;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public String listarEventos() {
        StringBuilder sb = new StringBuilder();
        NodoEvento actual = cabezaEventos;
        while (actual != null) {
            sb.append(actual.getEvento()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    public Evento buscarEvento(String nombre) {
        NodoEvento actual = cabezaEventos;
        while (actual != null) {
            if (actual.getEvento().getNombre().equals(nombre)) {
                return actual.getEvento();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void eliminarEvento(String nombre) {
        NodoEvento actual = cabezaEventos;
        NodoEvento previo = null;
        while (actual != null) {
            if (actual.getEvento().getNombre().equals(nombre)) {
                if (previo == null) {
                    cabezaEventos = actual.getSiguiente();
                } else {
                    previo.setSiguiente(actual.getSiguiente());
                }
                return;
            }
            previo = actual;
            actual = actual.getSiguiente();
        }
    }

    // Clase interna NodoEvento
    private class NodoEvento {
        private Evento evento;
        private NodoEvento siguiente;

        public NodoEvento(Evento evento) {
            this.evento = evento;
            this.siguiente = null;
        }

        public Evento getEvento() {
            return evento;
        }

        public void setEvento(Evento evento) {
            this.evento = evento;
        }

        public NodoEvento getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoEvento siguiente) {
            this.siguiente = siguiente;
        }
    }
}
