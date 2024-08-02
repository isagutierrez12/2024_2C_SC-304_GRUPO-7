package proyectofinal;


import java.util.Date;

public class Partido {
    private String equipo1;
    private String equipo2;
    private Date fecha;

    public Partido(String equipo1, String equipo2, Date fecha) {
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
}
