package modelo;

import java.util.Random;

public class Tablero {
    private Casilla[][] tablero;
    private final int filas = 10;
    private final int columnas = 10;
    private final int totalMinas = 10;

    public Tablero() {
        tablero = new Casilla[filas][columnas];
        inicializarTablero();
    }

    private void inicializarTablero() {
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casilla();
            }
        }
        colocarMinas(random);
        calcularMinasAdyacentes();
    }

    private void colocarMinas(Random random) {
        int minasColocadas = 0;
        while (minasColocadas < totalMinas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (!tablero[fila][columna].tieneMina()) {
                tablero[fila][columna].colocarMina();
                minasColocadas++;
            }
        }
    }

    void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!tablero[i][j].tieneMina()) {
                    tablero[i][j].setMinasAdyacentes(contarMinasAdyacentes(i, j));
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                    if (tablero[nuevaFila][nuevaColumna].tieneMina()) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public Casilla getCasilla(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return tablero[fila][columna];
        } else {
            throw new IndexOutOfBoundsException("Coordenadas fuera del tablero.");
        }
    }

    public void mostrarTablero() {
        System.out.print("   ");
        for (int i = 1; i <= columnas; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < columnas; j++) {
                Casilla casilla = tablero[i][j];
                if (casilla.estaDescubierta()) {
                    if (casilla.tieneMina()) {
                        System.out.print("X ");
                    } else {
                        System.out.print(casilla.getMinasAdyacentes() + " ");
                    }
                } else if (casilla.estaMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
