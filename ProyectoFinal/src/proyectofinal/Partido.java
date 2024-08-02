package proyectofinal;


import java.util.Date;

public class Partido {
    private Evento evento;
    private String equipo1;
    private String equipo2;
    private Participante participante;
    private Date fecha;
    private Partido atras;

    public Partido(Evento evento,String equipo1, String equipo2, Date fecha) {
        this.evento = evento;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return "Partido: " + equipo1 + " vs " + equipo2 + ", Fecha: " + fecha;
    }

    public Date getFecha() {
        return fecha;
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

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Partido getAtras() {
        return atras;
    }

    public void setAtras(Partido atras) {
        this.atras = atras;
    }
    
}
