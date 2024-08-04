package proyectofinal;

import javax.swing.JOptionPane;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static ListaEventos listaEventos = new ListaEventos();

    public static void main(String[] args) {
        cargarDatos();

        boolean salir = false;
        while (!salir) {
            String menu = "1. Registrar Evento\n"
                    + "2. Actualizar Evento\n"
                    + "3. Eliminar Evento\n"
                    + "4. Mostrar Eventos\n"
                    + "5. Registrar Participante\n"
                    + "6. Eliminar Participante\n"
                    + "7. Mostrar Participantes\n"
                    + "8. Salir";
            String opcionStr = JOptionPane.showInputDialog(menu);
            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    registrarEvento();
                    break;
                case 2:
                    actualizarEvento();
                    break;
                case 3:
                    eliminarEvento();
                    break;
                case 4:
                    mostrarEventos();
                    break;
                case 5:
                    registrarParticipante();
                    break;
                case 6:
                    eliminarParticipante();
                    break;
                case 7:
                    mostrarParticipantes();
                    break;
                case 8:
                    guardarDatos();
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    private static void registrarEvento() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del Evento:");
            String fechaStr = JOptionPane.showInputDialog("Fecha del Evento (yyyy-MM-dd):");
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            String ubicacion = JOptionPane.showInputDialog("Ubicación del Evento:");
            
            Evento evento = new Evento(nombre, fecha, ubicacion);
            listaEventos.agregarEvento(evento);
            JOptionPane.showMessageDialog(null, "Evento registrado exitosamente.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
        }
    }

    private static void actualizarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Nombre del Evento a actualizar:");
        Evento evento = listaEventos.buscarEvento(nombreEvento);
        if (evento != null) {
            try {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del Evento:", evento.getNombre());
                String nuevaFechaStr = JOptionPane.showInputDialog("Nueva Fecha del Evento (yyyy-MM-dd):", new SimpleDateFormat("yyyy-MM-dd").format(evento.getFecha()));
                Date nuevaFecha = new SimpleDateFormat("yyyy-MM-dd").parse(nuevaFechaStr);
                String nuevaUbicacion = JOptionPane.showInputDialog("Nueva Ubicación del Evento:", evento.getUbicacion());

                evento.actualizarInformacion(nuevoNombre, nuevaFecha, nuevaUbicacion);
                JOptionPane.showMessageDialog(null, "Evento actualizado exitosamente.");
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
        }
    }

    private static void eliminarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Nombre del Evento a eliminar:");
        listaEventos.eliminarEvento(nombreEvento);
        JOptionPane.showMessageDialog(null, "Evento eliminado si existía.");
    }

    private static void mostrarEventos() {
        String eventos = listaEventos.listarEventos();
        JOptionPane.showMessageDialog(null, eventos.isEmpty() ? "No hay eventos registrados." : eventos);
    }

    private static void registrarParticipante() {
        String nombreEvento = JOptionPane.showInputDialog("Nombre del Evento para registrar el participante:");
        Evento evento = listaEventos.buscarEvento(nombreEvento);
        if (evento != null) {
            String nombreParticipante = JOptionPane.showInputDialog("Nombre del Participante:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del Participante:"));
            String equipo = JOptionPane.showInputDialog("Equipo del Participante:");
            Participante participante = new Participante(nombreParticipante, edad, equipo);
            evento.agregarParticipante(participante);
            JOptionPane.showMessageDialog(null, "Participante registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
        }
    }

    private static void eliminarParticipante() {
        String nombreEvento = JOptionPane.showInputDialog("Nombre del Evento para eliminar el participante:");
        Evento evento = listaEventos.buscarEvento(nombreEvento);
        if (evento != null) {
            String nombreParticipante = JOptionPane.showInputDialog("Nombre del Participante a eliminar:");
            evento.eliminarParticipante(nombreParticipante);
            JOptionPane.showMessageDialog(null, "Participante eliminado si existía.");
        } else {
            JOptionPane.showMessageDialog(null, "Evento no encontrado.");
        }
    }

    private static void mostrarParticipantes() {
        String nombreEvento = JOptionPane.showInputDialog("Nombre del Evento para mostrar los participantes:");
        Evento evento = listaEventos.buscarEvento(nombreEvento);
        if (evento != null) {
            NodoParticipante actual = evento.getCabezaParticipantes();
            StringBuilder sb = new StringBuilder();
            while (actual != null) {
                sb.append(actual.getParticipante()).append("\n");
                actual = actual.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, sb.toString
