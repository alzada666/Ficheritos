package ejercicio4.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaManager {
    private static final String RUTA_FICHERO = "ficheros/mesas.dat";

    public static void guardarMesa(Mesa mesa) {
        try (
            FileOutputStream fos = new FileOutputStream(RUTA_FICHERO, true);
            ObjectOutputStream oos = new ObjectOutputStreamConCabecera(fos)
        ) {
            oos.writeObject(mesa);
            System.out.println("Mesa guardada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la mesa: " + e.getMessage());
        }
    }

    public static List<Mesa> obtenerMesas() {
        List<Mesa> lista = new ArrayList<>();

        try (
            FileInputStream fis = new FileInputStream(RUTA_FICHERO);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            while (true) {
                Mesa m = (Mesa) ois.readObject();
                lista.add(m);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (Exception e) {
            System.err.println("Error al leer mesas: " + e.getMessage());
        }

        return lista;
    }

    // Evita escribir cabecera duplicada en ObjectOutputStream cuando se añade
    private static class ObjectOutputStreamConCabecera extends ObjectOutputStream {
        public ObjectOutputStreamConCabecera(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            File file = new File(RUTA_FICHERO);
            if (file.length() == 0) {
                super.writeStreamHeader();
            } else {
                reset(); // Evita escribir la cabecera otra vez
            }
        }
    }
}
