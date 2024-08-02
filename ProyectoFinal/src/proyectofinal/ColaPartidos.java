package proyectofinal;

public class ColaPartidos {

    private Partido frente;
    private Partido ultimo;

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

    public void enCola(Partido d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
    }

    public Partido eliminar() {
        Partido aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;
    }

    public String calendarioEvento(Evento evento) {
        String s = "";
        Partido aux = frente;
        while (aux != null) {
            if (aux.getEvento() == evento) {
                s += aux + "\n";
            }
            aux = aux.getAtras();
        }
        return s;
    }
}
