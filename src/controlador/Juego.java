package controlador;

import modelo.Casilla;
import modelo.Tablero;
import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private boolean juegoActivo;

    public Juego() {
        tablero = new Tablero();
        juegoActivo = true;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        if (GestorDeArchivos.existeJuegoGuardado()) {
            System.out.print("¿Deseas cargar el juego guardado? (S/N): ");
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("S")) {
                try {
                    tablero = GestorDeArchivos.cargarJuego();
                } catch (Exception e) {
                    System.out.println("Error al cargar el juego: " + e.getMessage());
                }
            }
        }

        System.out.println("¡Bienvenido al juego de Buscaminas!");
        while (juegoActivo) {
            tablero.mostrarTablero();
            System.out.println("[1] Descubrir casilla");
            System.out.println("[2] Marcar casilla");
            System.out.println("[3] Guardar y salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Introduce la coordenada (por ejemplo, A5): ");
                        manejarDescubrimiento(scanner.nextLine().toUpperCase());
                    }
                    case 2 -> {
                        System.out.print("Introduce la coordenada (por ejemplo, A5): ");
                        manejarMarcado(scanner.nextLine().toUpperCase());
                    }
                    case 3 -> {
                        GestorDeArchivos.guardarJuego(tablero);
                        juegoActivo = false;
                    }
                    default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }



    private void manejarDescubrimiento(String coordenada) throws Exception {
        int fila = coordenada.charAt(0) - 'A';
        int columna = Integer.parseInt(coordenada.substring(1)) - 1;

        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            throw new Exception("Coordenada fuera del tablero. Inténtalo de nuevo.");
        }

        Casilla casilla = tablero.getCasilla(fila, columna);

        if (casilla.estaDescubierta()) {
            throw new Exception("Esta casilla ya ha sido descubierta.");
        }

        if (casilla.tieneMina()) {
            tablero.mostrarTablero();
            System.out.println("¡Has encontrado una mina! ¡Has perdido!");
            juegoActivo = false;
        } else {
            descubrirRecursivo(fila, columna);
            verificarVictoria();
        }
    }

    private void manejarMarcado(String coordenada) throws Exception {
        int fila = coordenada.charAt(0) - 'A';
        int columna = Integer.parseInt(coordenada.substring(1)) - 1;

        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            throw new Exception("Coordenada fuera del tablero. Inténtalo de nuevo.");
        }

        Casilla casilla = tablero.getCasilla(fila, columna);
        casilla.marcar();
    }

    private void descubrirRecursivo(int fila, int columna) {
        // Lógica para descubrir recursivamente casillas vacías
    }

    private void verificarVictoria() {
        // Lógica para verificar si todas las casillas seguras han sido descubiertas
    }
}
