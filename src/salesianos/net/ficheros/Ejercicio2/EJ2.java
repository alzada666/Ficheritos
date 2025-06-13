package salesianos.net.ficheros.Ejercicio2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class EJ2 {

    public static void main(String[] args) {
        String nombreFichero = "ficheros/texto2.txt";
        String mensaje = "Hola, pibe."; 

        //  Crear carpeta si no existe
        File carpeta = new File("ficheros");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        //  Escribir el mensaje en el fichero
        try (FileWriter fw = new FileWriter(nombreFichero)) {
            fw.write(mensaje);
            System.out.println("Texto escrito en el fichero correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
            return;
        }

        //  Leer carácter por carácter y mostrar con su código ASCII
        try (FileReader fr = new FileReader(nombreFichero)) {
            int code;
            System.out.println("\nContenido del fichero con códigos ASCII:");
            while ((code = fr.read()) != -1) {
                char caracter = (char) code;
                System.out.print(caracter + "_" + code);
                if (fr.ready()) {
                    System.out.print(", ");
                }
            }
            System.out.println(); 
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}

