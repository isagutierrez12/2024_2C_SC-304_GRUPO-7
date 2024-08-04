package proyectofinal;

public class Participante {
    private String nombre;
    private int edad;
    private String equipo;
    private Participante siguiente;
    private Participante anterior;

    public Participante(String nombre, int edad, String equipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.siguiente = null;
        this.anterior = null;
    }

    // Métodos para obtener y establecer la información del participante
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Participante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Participante siguiente) {
        this.siguiente = siguiente;
    }

    public Participante getAnterior() {
        return anterior;
    }

    public void setAnterior(Participante anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Participante: " + nombre + ", Edad: " + edad + ", Equipo: " + equipo;
    }
}

