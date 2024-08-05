import javax.swing.JOptionPane;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static ListaEventos listaEventos = new ListaEventos();
    private static ListaParticipantes listaParticipantes = new ListaParticipantes();

    public static void main(String[] args) {
        // Cargamos los datos desde el archivo al iniciar el programa
        cargarDatos();

        boolean salir = false;
        while (!salir) {
            // Menú principal con las opciones disponibles
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

            // Ejecutamos la opción seleccionada por el usuario
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
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción del 1 al 8.");
                    break;
            }
        }
    }

    // Método para registrar un nuevo evento
    private static void registrarEvento() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
            String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha del evento (yyyy-MM-dd):");
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación del evento:");

            Evento evento = new Evento(nombre, fecha, ubicacion);
            listaEventos.agregarEvento(evento);
            JOptionPane.showMessageDialog(null, "El evento ha sido registrado exitosamente.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
        }
    }

    // Método para actualizar la información de un evento existente
    private static void actualizarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento a actualizar:");
        Evento evento = listaEventos.buscarEvento(nombreEvento);
        if (evento != null) {
            try {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del evento:", evento.getNombre());
                String nuevaFechaStr = JOptionPane.showInputDialog("Ingrese la nueva fecha del evento (yyyy-MM-dd):", new SimpleDateFormat("yyyy-MM-dd").format(evento.getFecha()));
                Date nuevaFecha = new SimpleDateFormat("yyyy-MM-dd").parse(nuevaFechaStr);
                String nuevaUbicacion = JOptionPane.showInputDialog("Ingrese la nueva ubicación del evento:", evento.getUbicacion());

                evento.actualizarInformacion(nuevoNombre, nuevaFecha, nuevaUbicacion);
                JOptionPane.showMessageDialog(null, "El evento ha sido actualizado exitosamente.");
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use el formato yyyy-MM-dd.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el evento con el nombre proporcionado.");
        }
    }

    // Método para eliminar un evento por su nombre
    private static void eliminarEvento() {
        String nombreEvento = JOptionPane.showInputDialog("Ingrese el nombre del evento a eliminar:");
        if (listaEventos.eliminarEvento(nombreEvento)) {
            JOptionPane.showMessageDialog(null, "El evento ha sido eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el evento con el nombre proporcionado.");
        }
    }

    // Método para mostrar todos los eventos registrados
    private static void mostrarEventos() {
        String eventos = listaEventos.mostrarEventos();
        JOptionPane.showMessageDialog(null, eventos.isEmpty() ? "No hay eventos registrados en el sistema." : eventos);
    }

    // Método para registrar un nuevo participante
    private static void registrarParticipante() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del participante:");
        String edadStr = JOptionPane.showInputDialog("Ingrese la edad del participante:");
        int edad = Integer.parseInt(edadStr);
        String equipo = JOptionPane.showInputDialog("Ingrese el equipo del participante:");

        Participante participante = new Participante(nombre, edad, equipo);
        listaParticipantes.agregarParticipante(participante);
        JOptionPane.showMessageDialog(null, "El participante ha sido registrado exitosamente.");
    }

    // Método para eliminar un participante por su nombre
    private static void eliminarParticipante() {
        String nombreParticipante = JOptionPane.showInputDialog("Ingrese el nombre del participante a eliminar:");
        if (listaParticipantes.eliminarParticipante(nombreParticipante)) {
            JOptionPane.showMessageDialog(null, "El participante ha sido eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el participante con el nombre proporcionado.");
        }
    }

    // Método para mostrar todos los participantes registrados
    private static void mostrarParticipantes() {
        String participantes = listaParticipantes.mostrarParticipantes();
        JOptionPane.showMessageDialog(null, participantes.isEmpty() ? "No hay participantes registrados en el sistema." : participantes);
    }

    // Método para guardar todos los eventos en un archivo
    private static void guardarDatos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("eventos.txt"))) {
            NodoEvento actual = listaEventos.getCabezaEventos();
            while (actual != null) {
                Evento evento = actual.getEvento();
                writer.println(evento.getNombre() + "|" 
                               + new SimpleDateFormat("yyyy-MM-dd").format(evento.getFecha()) 
                               + "|" + evento.getUbicacion());
                actual = actual.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos. Verifique el archivo de destino.");
        }
    }

    // Método para cargar los eventos desde un archivo
    private static void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("eventos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(partes[1]);
                    String ubicacion = partes[2];
                    Evento evento = new Evento(nombre, fecha, ubicacion);
                    listaEventos.agregarEvento(evento);
                } else {
                    JOptionPane.showMessageDialog(null, "Formato incorrecto en la línea: " + linea);
                }
            }
            JOptionPane.showMessageDialog(null, "Datos cargados exitosamente.");
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos. Verifique el archivo de origen.");
        }
    }
}
