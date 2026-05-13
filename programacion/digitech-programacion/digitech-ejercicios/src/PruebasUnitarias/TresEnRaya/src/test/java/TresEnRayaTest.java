import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TresEnRayaTest {

    @Test
    void ColocarFichaCorrectamente() {
        TresEnRaya juego = new TresEnRaya();

        boolean ficha = juego.realizarMovimiento(0, 0);
        assertTrue(ficha);
        assertEquals(1, juego.getCasilla(0, 0));
    }

    @Test
    void colocarFichaFueraDelTablero() {
        TresEnRaya juego = new TresEnRaya();

        boolean exitoFila = juego.realizarMovimiento(3, 0);
        boolean exitoColumna = juego.realizarMovimiento(0, -1);

        assertFalse(exitoFila);
        assertFalse(exitoColumna);
    }

    @Test
    void colocarFichaEnCasillaOcupada() {
        TresEnRaya juego = new TresEnRaya();

        juego.realizarMovimiento(1, 1);
        boolean exito = juego.realizarMovimiento(1, 1);

        assertFalse(exito);
    }

    @Test
    void ganarPorFila() {
        TresEnRaya juego = new TresEnRaya();

        juego.realizarMovimiento(0, 0);
        juego.realizarMovimiento(1, 0);
        juego.realizarMovimiento(0, 1);
        juego.realizarMovimiento(1, 1);
        juego.realizarMovimiento(0, 2);

        assertTrue(juego.comprobarVictoria(1));
    }

    @Test
    void ganarPorColumna() {
        TresEnRaya juego = new TresEnRaya();

        juego.realizarMovimiento(0, 0);
        juego.realizarMovimiento(0, 1);
        juego.realizarMovimiento(1, 0);
        juego.realizarMovimiento(1, 1);
        juego.realizarMovimiento(2, 0);

        assertTrue(juego.comprobarVictoria(1));
    }

    @Test
    void ganarPorDiagonalPrincipal() {
        TresEnRaya juego = new TresEnRaya();

        juego.realizarMovimiento(0, 0);
        juego.realizarMovimiento(0, 1);
        juego.realizarMovimiento(1, 1);
        juego.realizarMovimiento(0, 2);
        juego.realizarMovimiento(2, 2);

        assertTrue(juego.comprobarVictoria(1));
    }

    @Test
    void ganarPorDiagonalSecundaria() {
        TresEnRaya juego = new TresEnRaya();

        juego.realizarMovimiento(0, 2);
        juego.realizarMovimiento(0, 0);
        juego.realizarMovimiento(1, 1);
        juego.realizarMovimiento(0, 1);
        juego.realizarMovimiento(2, 0);

        assertTrue(juego.comprobarVictoria(1));
    }

    @Test
    void partidaSinGanador() {
        TresEnRaya juego = new TresEnRaya();

        juego.realizarMovimiento(0, 0);
        juego.realizarMovimiento(0, 1);
        juego.realizarMovimiento(0, 2);
        juego.realizarMovimiento(1, 1);
        juego.realizarMovimiento(1, 0);
        juego.realizarMovimiento(1, 2);
        juego.realizarMovimiento(2, 1);
        juego.realizarMovimiento(2, 0);
        juego.realizarMovimiento(2, 2);

        assertFalse(juego.comprobarVictoria(1));
        assertFalse(juego.comprobarVictoria(2));
        assertTrue(juego.esEmpate());
    }
}
