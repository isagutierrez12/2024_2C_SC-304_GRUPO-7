package proyectofinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Evento> listaEventos = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Código de inicialización
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
            System.out.println("3. Registrar Participante");
            System.out.println("4. Eliminar Participante");
            System.out.println("5. Actualizar Evento");
            System.out.println("6. Eliminar Evento");
            System.out.println("7. Listar Eventos");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            
            switch (opcion) {
                case 1:
                    programarPartido();
                    break;
                case 2:
                    mostrarCalendarioPartidos();
                    break;
                case 3:
                    registrarParticipante();
                    break;
                case 4:
                    eliminarParticipante();
                    break;
                case 5:
                    actualizarEvento();
                    break;
                case 6:
                    eliminarEvento();
                    break;
                case 7:
                    listarEventos();
                    break;
                case 8:
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
            
            System.out.print("Nombre del equipo 1: ");
            String equipo1 = scanner.nextLine();
            System.out.print("Nombre del equipo 2: ");
            String equipo2 = scanner.nextLine();
            
            System.out.print("Día del partido (1-31): ");
            int dia = scanner.nextInt();
            System.out.print("Mes del partido (1-12): ");
            int mes = scanner.nextInt();
            System.out.print("Año del partido (yyyy): ");
            int ano = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
                System.out.println("Fecha inválida.");
                return;
            }
            
            String fechaStr = String.format("%04d-%02d-%02d", ano, mes, dia);
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            
            // Crear y agregar el partido
            Partido partido = new Partido(evento, equipo1, equipo2, fecha);
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

    private static void registrarParticipante() {
        try {
            System.out.println("Seleccione el evento para registrar el participante (índice): ");
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
            
            System.out.print("Nombre del participante: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad del participante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            System.out.print("Equipo del participante: ");
            String equipo = scanner.nextLine();
            
            Participante participante = new Participante(nombre, edad, equipo);
            evento.agregarParticipante(participante);
            System.out.println("Participante registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al registrar el participante.");
        }
    }

    private static void eliminarParticipante() {
        try {
            System.out.println("Seleccione el evento para eliminar el participante (índice): ");
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
            
            System.out.println("Lista de participantes:");
            LinkedList<Participante> participantes = evento.getListaParticipantes();
            for (int i = 0; i < participantes.size(); i++) {
                System.out.println(i + ": " + participantes.get(i));
            }
            System.out.print("Seleccione el participante para eliminar (índice): ");
            int indexParticipante = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            
            if (indexParticipante < 0 || indexParticipante >= participantes.size()) {
                System.out.println("Índice de participante no válido.");
                return;
            }
            
            Participante participante = participantes.get(indexParticipante);
            evento.eliminarParticipante(participante);
            System.out.println("Participante eliminado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el participante.");
        }
    }

    private static void actualizarEvento() {
        try {
            System.out.println("Seleccione el evento para actualizar (índice): ");
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
            
            System.out.print("Nuevo nombre del evento: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nueva ubicación del evento: ");
            String nuevaUbicacion = scanner.nextLine();
            
            System.out.print("Nueva fecha del evento (yyyy-MM-dd): ");
            String nuevaFechaStr = scanner.nextLine();
            Date nuevaFecha = new SimpleDateFormat("yyyy-MM-dd").parse(nuevaFechaStr);
            
            evento.setNombre(nuevoNombre);
            evento.setUbicacion(nuevaUbicacion);
            evento.setFecha(nuevaFecha);
            System.out.println("Evento actualizado exitosamente.");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Formato de fecha inválido.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el evento.");
        }
    }

    private static void eliminarEvento() {
        try {
            System.out.println("Seleccione el evento para eliminar (índice): ");
            for (int i = 0; i < listaEventos.size(); i++) {
                System.out.println(i + ": " + listaEventos.get(i));
            }
            int indexEvento = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            
            if (indexEvento < 0 || indexEvento >= listaEventos.size()) {
                System.out.println("Índice de evento no válido.");
                return;
            }
            
            listaEventos.remove(indexEvento);
            System.out.println("Evento eliminado exitosamente.");
        } catch (
