import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaManager {
    private static final String RUTA_FICHERO = "ficheros/mesas.dat";

    public static void guardarMesa(Mesa mesa) {
        try {
            File carpeta = new File("ficheros");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileOutputStream fos = new FileOutputStream(RUTA_FICHERO, true);
            ObjectOutputStream oos = new ObjectOutputStreamConCabecera(fos);
            oos.writeObject(mesa);
            oos.close();

            System.out.println("Mesa guardada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la mesa: " + e.getMessage());
        }
    }

    public static List<Mesa> obtenerMesas() {
        List<Mesa> lista = new ArrayList<>();

        try {
            File carpeta = new File("ficheros");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            File fichero = new File(RUTA_FICHERO);
            if (!fichero.exists()) {
                return lista; // No hay mesas aún
            }

            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    Mesa m = (Mesa) ois.readObject();
                    lista.add(m);
                }
            } catch (EOFException e) {
                // Fin del archivo: OK
            } finally {
                ois.close();
            }

        } catch (Exception e) {
            System.err.println("Error al leer mesas: " + e.getMessage());
        }

        return lista;
    }

    // Para evitar múltiples cabeceras en ObjectOutputStream
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
                reset();
            }
        }
    }
}
