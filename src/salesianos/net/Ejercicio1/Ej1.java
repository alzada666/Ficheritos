package salesianos.net.Ejercicio1;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) {
        Console console = System.console();
        String texto;
        do {
            texto = console.readLine("Introduce un texto (m\u00ednimo 30 caracteres): ");
        } while (texto == null || texto.length() < 30);
        String formato = texto.toUpperCase().replace(' ', '_');
        try (FileWriter writer = new FileWriter("ficheros/texto1.txt")) {
            writer.write(formato);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
