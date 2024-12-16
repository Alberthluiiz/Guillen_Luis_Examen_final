package controlador;

import modelo.Casilla;
import modelo.Tablero;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juego {
    private static final Logger LOGGER = Logger.getLogger(Juego.class.getName());

    private Tablero tablero;
    private boolean juegoActivo;

    public Juego() {
        tablero = new Tablero();
        juegoActivo = true;
    }

    public void jugar() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (GestorDeArchivos.existeJuegoGuardado()) {
                cargarJuegoGuardado(scanner);
            }

            System.out.println("\u00a1Bienvenido al juego de Buscaminas!");
            while (juegoActivo) {
                tablero.mostrarTablero();
                mostrarMenu();

                int opcion = obtenerOpcionUsuario(scanner);
                ejecutarOpcion(opcion, scanner);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error inesperado durante el juego: {0}", e.getMessage());
        }
    }

    private void cargarJuegoGuardado(Scanner scanner) {
        System.out.print("\u00bfDeseas cargar el juego guardado? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        if (respuesta.equals("S")) {
            try {
                tablero = GestorDeArchivos.cargarJuego();
                System.out.println("Juego cargado correctamente.");
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Error al cargar el juego: {0}", e.getMessage());
                System.out.println("No se pudo cargar el juego guardado.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n[1] Descubrir casilla");
        System.out.println("[2] Marcar casilla");
        System.out.println("[3] Guardar y salir");
        System.out.print("Elige una opción: ");
    }

    private int obtenerOpcionUsuario(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            LOGGER.warning("Opción inválida. Introduzca un número.");
            return -1; // Opción inválida
        }
    }

    private void ejecutarOpcion(int opcion, Scanner scanner) {
        try {
            switch (opcion) {
                case 1 -> manejarDescubrimiento(coordenadaDesdeUsuario(scanner));
                case 2 -> manejarMarcado(coordenadaDesdeUsuario(scanner));
                case 3 -> {
                    GestorDeArchivos.guardarJuego(tablero);
                    juegoActivo = false;
                    System.out.println("Juego guardado. Hasta luego.");
                }
                default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.warning("Error inesperado: " + e.getMessage());
            System.out.println("Ocurrió un error inesperado. Inténtalo de nuevo.");
        }
    }

    private String coordenadaDesdeUsuario(Scanner scanner) {
        System.out.print("Introduce la coordenada (por ejemplo, A5): ");
        return scanner.nextLine().trim().toUpperCase();
    }

    private void manejarDescubrimiento(String coordenada) {
        int[] coordenadas = convertirCoordenada(coordenada);
        int fila = coordenadas[0];
        int columna = coordenadas[1];

        Casilla casilla = tablero.getCasilla(fila, columna);

        if (casilla.estaDescubierta()) {
            System.out.println("Esta casilla ya ha sido descubierta.");
            return;
        }

        if (casilla.tieneMina()) {
            tablero.mostrarTablero();
            System.out.println("\u00a1Has encontrado una mina! \u00a1Has perdido!");
            juegoActivo = false;
        } else {
            descubrirRecursivo(fila, columna);
            verificarVictoria();
        }
    }

    private void manejarMarcado(String coordenada) {
        int[] coordenadas = convertirCoordenada(coordenada);
        int fila = coordenadas[0];
        int columna = coordenadas[1];

        Casilla casilla = tablero.getCasilla(fila, columna);
        casilla.marcar();
        System.out.println("Casilla marcada correctamente.");
    }

    private int[] convertirCoordenada(String coordenada) {
        if (coordenada.length() < 2) {
            throw new IllegalArgumentException("Formato de coordenada inválido.");
        }

        int fila = coordenada.charAt(0) - 'A';
        int columna;
        try {
            columna = Integer.parseInt(coordenada.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El número de columna no es válido.");
        }

        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            throw new IllegalArgumentException("Coordenada fuera del tablero.");
        }

        return new int[]{fila, columna};
    }

    private void descubrirRecursivo(int fila, int columna) {
        // TODO: Implementar lógica para descubrir recursivamente casillas vacías.
        System.out.println("Descubriendo casillas vacías recursivamente... (pendiente de implementar)");
    }

    private void verificarVictoria() {
        // TODO: Implementar lógica para verificar si se descubrieron todas las casillas seguras.
        System.out.println("Verificando victoria... (pendiente de implementar)");
    }
}
