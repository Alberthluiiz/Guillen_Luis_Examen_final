package controlador;

import modelo.Tablero;
import java.io.*;

public class GestorDeArchivos {
    private static final String ARCHIVO_GUARDADO = "estado_juego.dat";

    // Guardar el estado del juego
    public static void guardarJuego(Tablero tablero) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_GUARDADO))) {
            oos.writeObject(tablero);
            System.out.println("Juego guardado exitosamente.");
        }
    }

    // Cargar el estado del juego
    public static Tablero cargarJuego() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_GUARDADO))) {
            System.out.println("Juego cargado exitosamente.");
            return (Tablero) ois.readObject();
        }
    }

    // Verificar si existe un archivo guardado
    public static boolean existeJuegoGuardado() {
        File file = new File(ARCHIVO_GUARDADO);
        return file.exists();
    }
}
