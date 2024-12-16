package modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void testInicializarTablero() {
        Tablero tablero = new Tablero();
        assertNotNull(tablero, "El tablero no debe ser nulo después de inicializarlo.");
    }

    @Test
    void testColocarMinas() {
        Tablero tablero = new Tablero();
        int cantidadMinas = contarMinas(tablero);
        assertEquals(10, cantidadMinas, "El tablero debe tener exactamente 10 minas.");
    }

    @Test
    void testCalcularMinasAdyacentes() {
        Tablero tablero = new Tablero();

        // Colocar una mina manualmente en la esquina superior izquierda
        tablero.getCasilla(0, 0).colocarMina();

        // Recalcular las minas adyacentes después de colocar la mina
        tablero.calcularMinasAdyacentes();

        // Validar que la casilla adyacente a la derecha tenga el valor esperado
        assertEquals(1, tablero.getCasilla(0, 1).getMinasAdyacentes(),
                "La casilla derecha adyacente debe tener 1 mina adyacente.");
    }

    /**
     * Método auxiliar para contar el número de minas en un tablero.
     *
     * @param tablero Tablero a analizar.
     * @return Cantidad de minas en el tablero.
     */
    private int contarMinas(Tablero tablero) {
        int minas = 0;
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                if (tablero.getCasilla(fila, columna).tieneMina()) {
                    minas++;
                }
            }
        }
        return minas;
    }
}
