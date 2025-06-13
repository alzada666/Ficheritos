package ejercicio4.src

import java.io.Console;
import java.util.List;

public class EJ4 {

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.err.println("Consola no disponible. Ejecuta desde terminal.");
            return;
        }

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Nueva mesa");
            System.out.println("2. Mostrar mesas almacenadas");
            System.out.println("0. Salir");
            String opcion = console.readLine("Elige una opción: ");

            switch (opcion) {
                case "1":
                    String color = console.readLine("Color de la mesa: ");
                    int patas = Integer.parseInt(console.readLine("Número de patas: "));
                    Mesa mesa = new Mesa(color, patas);
                    MesaManager.guardarMesa(mesa);
                    break;

                case "2":
                    List<Mesa> mesas = MesaManager.obtenerMesas();
                    if (mesas.isEmpty()) {
                        System.out.println("No hay mesas guardadas.");
                    } else {
                        System.out.println("\nListado de mesas:");
                        for (Mesa m : mesas) {
                            System.out.println("- " + m);
                        }
                    }
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

