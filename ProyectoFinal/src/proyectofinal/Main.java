import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Evento> listaEventos = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Agregar eventos de prueba
        try {
            Evento evento = new Evento("Fútbol", new SimpleDateFormat("yyyy-MM-dd").parse("2024-08-15"), "Estadio Nacional");
            listaEventos.add(evento);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Programar Partido");
            System.out.println("2. Mostrar Calendario de Partidos");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer un entero
            
            switch (opcion) {
                case 1:
                    programarPartido();
                    break;
                case 2:
                    mostrarCalendarioPartidos();
                    break;
                case 3:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, por favor selecciona de nuevo.");
                    break;
            }
        }
    }

    private static void programarPartido() {
        try {
            // Seleccionar evento
            System.out.println("Seleccione el evento (índice): ");
            for (int i = 0; i < listaEventos.size(); i++) {
                System.out.println(i + ": " + listaEventos.get(i));
            }
            int indexEvento = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            
            if (indexEvento < 0 || indexEvento >= listaEventos.size()) {
                System.out.println("Índice de evento no válido.");
                return;
            }
            
            Evento evento = listaEventos.get(indexEvento);
            
            // Obtener detalles del partido
            System.out.print("Nombre del equipo 1: ");
            String equipo1 = scanner.nextLine();
            System.out.print("Nombre del equipo 2: ");
            String equipo2 = scanner.nextLine();
            
            // Obtener fecha del partido
            System.out.print("Día del partido (1-31): ");
            int dia = scanner.nextInt();
            System.out.print("Mes del partido (1-12): ");
            int mes = scanner.nextInt();
            System.out.print("Año del partido (yyyy): ");
            int ano = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            
            // Validar la fecha
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
                System.out.println("Fecha inválida.");
                return;
            }
            
            String fechaStr = String.format("%04d-%02d-%02d", ano, mes, dia);
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            
            // Crear y agregar el partido
            Partido partido = new Partido(equipo1, equipo2, fecha);
            evento.programarPartido(partido);
            System.out.println("Partido programado exitosamente.");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Formato de fecha inválido.");
        }
    }

    private static void mostrarCalendarioPartidos() {
        System.out.println("Seleccione el evento para mostrar el calendario (índice): ");
        for (int i = 0; i < listaEventos.size(); i++) {
            System.out.println(i + ": " + listaEventos.get(i));
        }
        int indexEvento = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea
        
        if (indexEvento < 0 || indexEvento >= listaEventos.size()) {
            System.out.println("Índice de evento no válido.");
            return;
        }
        
        Evento evento = listaEventos.get(indexEvento);
        evento.mostrarCalendarioPartidos();
    }
}
