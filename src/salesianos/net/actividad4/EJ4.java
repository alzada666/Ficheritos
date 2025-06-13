

import java.util.List;
import java.util.Scanner;

public class EJ4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Nueva mesa");
            System.out.println("2. Mostrar mesas almacenadas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Color de la mesa: ");
                    String color = sc.nextLine();

                    int patas = 0;
                    boolean valido = false;
                    while (!valido) {
                        System.out.print("Número de patas: ");
                        String entrada = sc.nextLine();
                        try {
                            patas = Integer.parseInt(entrada);
                            valido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Número no válido. Intenta de nuevo.");
                        }
                    }

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
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}