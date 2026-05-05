import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculadoraTest {
    @Test
    void SumaPositivos() {
        Float resultado = Calculadora.suma(5, 2);
        assertEquals(7.0f, resultado);
    }

    @Test
    void SumaNegativos() {
        Float resultado = Calculadora.suma(-1, -2);
        assertNull(resultado);
    }

    @Test
    void Resta() {
        Float resultado = Calculadora.resta(5, 2);
        assertEquals(3.0f, resultado);
    }

    @Test
    void MultiplicarPorCero() {
        Float resultado = Calculadora.multiplicacion(5, 0);
        assertNull(resultado);
    }

    @Test
    void DividirEntreCero() {
        Float resultado = Calculadora.division(5, 0);
        assertNull(resultado);
    }

    @Test
    void DividirEntreNegativos() {
        Float resultado = Calculadora.division(-5, -2);
        assertNull(resultado);
    }

    @Test
    void DivisionCorrecta() {
        Float resultado = Calculadora.division(10, 2);
        assertEquals(5.0f, resultado);
    }
}


