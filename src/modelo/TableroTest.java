package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void testInicializarTablero() {
        Tablero tablero = new Tablero();
        assertNotNull(tablero);
    }

    @Test
    void testColocarMinas() {
        Tablero tablero = new Tablero();
        int minas = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.getCasilla(i, j).tieneMina()) {
                    minas++;
                }
            }
        }
        assertEquals(10, minas);
    }

    @Test
    void testCalcularMinasAdyacentes() {
        Tablero tablero = new Tablero();
        // Colocar una mina manualmente para verificar
        tablero.getCasilla(0, 0).colocarMina();
        tablero.calcularMinasAdyacentes();
        assertEquals(1, tablero.getCasilla(0, 1).getMinasAdyacentes());
    }
}
