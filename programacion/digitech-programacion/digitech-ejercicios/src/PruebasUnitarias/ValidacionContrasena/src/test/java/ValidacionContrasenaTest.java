c

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidacionContrasenaTest {

    @Test
    void ContrasenaValida() {
        ValidacionContrasena val = new ValidacionContrasena();
        String contrasena = "Europa20";
        assertTrue(val.Validacion(contrasena));
    }

    @Test
    void Menos8Carac() {
        ValidacionContrasena val = new ValidacionContrasena();
        String contrasena = "Europa";
        assertFalse(val.Validacion(contrasena));
    }

    @Test
    void SinMayuscula() {
        ValidacionContrasena val = new ValidacionContrasena();
        String contrasena = "europa20";
        assertFalse(val.Validacion(contrasena));
    }

    @Test
    void SinNumeros() {
        ValidacionContrasena val = new ValidacionContrasena();
        String contrasena = "Europeas";
        assertFalse(val.Validacion(contrasena));
    }

    @Test
    void CadenaVacia() {
        ValidacionContrasena val = new ValidacionContrasena();
        String contrasena = "        ";
        assertFalse(val.Validacion(contrasena));
    }

    @Test
    void ContraseñaConEspacios() {
        ValidacionContrasena val = new ValidacionContrasena();
        String contrasena = "Europa 20";
        assertFalse(val.Validacion(contrasena));
    }

}
