package proyectofinal;

import java.util.Date;

public class ColaPartidos {

    private Partido frente;
    private Partido ultimo;

    public ColaPartidos() {
        this.frente = null;
        this.ultimo = null;
    }

    public Partido getFrente() {
        return frente;
    }

    public void setFrente(Partido frente) {
        this.frente = frente;
    }

    public Partido getUltimo() {
        return ultimo;
    }

    public void setUltimo(Partido ultimo) {
        this.ultimo = ultimo;
    }

    // Método para agregar un partido al final de la cola
    public void enCola(Partido d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
    }

    // Método para eliminar un partido del frente de la cola
    public Partido eliminar() {
        Partido aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            if (frente == null) {  // Si la cola queda vacía
                ultimo = null;
            }
            aux.setAtras(null);
        }
        return aux;
    }

    // Método para mostrar el calendario de partidos para un evento específico
    public String calendarioEvento(Evento evento) {
        StringBuilder sb = new StringBuilder();
        Partido aux = frente;
        while (aux != null) {
            if (aux.getEvento().equals(evento)) {
                sb.append(aux).append("\n");
            }
            aux = aux.getAtras();
        }
        return sb.toString();
    }
}
