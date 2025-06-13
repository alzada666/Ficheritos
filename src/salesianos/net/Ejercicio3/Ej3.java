

import java.io.*;

public class Ej3 {

    public static void main(String[] args) {
        String rutaFichero1 = "ficheros/texto1.txt";
        String rutaFichero2 = "ficheros/texto2.txt";
        String rutaFicheroFusionado = "ficheros/fusion.txt";

        // Crear carpeta si no existe
        File carpeta = new File("ficheros");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaFicheroFusionado))) {

            // Encabezado de fusión
            writer.println("=== INICIO DEL FICHERO FUSIONADO ===\n");

            // Contenido del fichero 1
            writer.println("-- Contenido de texto1.txt --");
            try (BufferedReader reader1 = new BufferedReader(new FileReader(rutaFichero1))) {
                String linea;
                while ((linea = reader1.readLine()) != null) {
                    writer.println(linea);
                }
            }

            writer.println(); // línea en blanco

            // Contenido del fichero 2
            writer.println("-- Contenido de texto2.txt --");
            try (BufferedReader reader2 = new BufferedReader(new FileReader(rutaFichero2))) {
                int caracter;
                while ((caracter = reader2.read()) != -1) {
                    writer.print((char) caracter);
                }
            }

            writer.println(); // línea en blanco
            writer.println("\n=== FIN DEL FICHERO ===");
            writer.println("Firmado por: Marcos Padron");

            System.out.println("Fusión completada correctamente en " + rutaFicheroFusionado);

        } catch (IOException e) {
            System.err.println("Error durante la fusión: " + e.getMessage());
        }
    }
}
