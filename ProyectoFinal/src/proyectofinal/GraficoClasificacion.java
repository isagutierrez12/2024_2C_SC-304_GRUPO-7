package com.mycompany.evento;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class GraficoClasificacion extends JPanel {

    private int[] puntos = {8, 4, 7, 5, 3, 6, 4, 2};
    private String[] equipos = {"Equipo A", "Equipo B", "Equipo C", "Equipo D", "Equipo E", "Equipo F", "Equipo G", "Equipo H"};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Configuración del gráfico
        int ancho = getWidth();
        int alto = getHeight();
        int margenIzquierda = 70;
        int margenDerecha = 30;
        int margenInferior = 80;
        int margenSuperior = 40;
        int espacioEntreBarras = 20;

        int anchoBarra = (ancho - margenIzquierda - margenDerecha - (espacioEntreBarras * (puntos.length - 1))) / puntos.length;

        // Encontrar el valor máximo en puntos
        int maxPuntos = 0;
        for (int punto : puntos) {
            if (punto > maxPuntos) {
                maxPuntos = punto;
            }
        }

        // Configurar fuente para etiquetas
        Font font = new Font("SansSerif", Font.BOLD, 14);
        g2d.setFont(font);

        // Dibujar las barras
        for (int i = 0; i < puntos.length; i++) {
            int alturaBarra = (puntos[i] * (alto - margenSuperior - margenInferior)) / maxPuntos;
            int x = margenIzquierda + i * (anchoBarra + espacioEntreBarras);
            int y = alto - margenInferior - alturaBarra;

            // Configurar el color y el estilo de las barras
            g2d.setColor(new Color(70, 130, 180)); // Color de la barra
            RoundRectangle2D barra = new RoundRectangle2D.Double(x, y, anchoBarra, alturaBarra, 15, 15);
            g2d.fill(barra);

            g2d.setColor(Color.BLACK);
            g2d.draw(barra); // Borde de la barra

            // Ajustar el espacio para etiquetas de los equipos
            String etiqueta = equipos[i];
            FontMetrics fm = g2d.getFontMetrics();
            int etiquetaX = x + (anchoBarra / 2) - fm.stringWidth(etiqueta) / 2;
            int etiquetaY = alto - margenInferior + 20;
            g2d.drawString(etiqueta, etiquetaX, etiquetaY);
        }

        // Dibujar el eje Y
        g2d.drawLine(margenIzquierda, margenSuperior, margenIzquierda, alto - margenInferior);
        // Dibujar el eje X
        g2d.drawLine(margenIzquierda, alto - margenInferior, ancho - margenDerecha, alto - margenInferior);

        // Dibujar etiquetas del eje Y
        g2d.setColor(Color.BLACK);
        for (int i = 0; i <= maxPuntos; i += 1) {
            int y = alto - margenInferior - (i * (alto - margenSuperior - margenInferior)) / maxPuntos;
            g2d.drawString(String.valueOf(i), margenIzquierda - 40, y + 5);
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Clasificación de Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new GraficoClasificacion());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraficoClasificacion::createAndShowGUI);
    }
}
