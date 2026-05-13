public class ValidacionContrasena {

    public boolean Validacion(String contraseña) {

        if (contraseña.length() < 8) {
            RequisitosMinimos();
            return false;
        }

        if (!contraseña.matches(".*[A-Z].*")) {
            RequisitosMinimos();
            return false;
        }

        if (!contraseña.matches(".*[a-z].*")) {
            RequisitosMinimos();
            return false;
        }

        if (!contraseña.matches(".*[0-9].*")) {
            RequisitosMinimos();
            return false;
        }

        if (contraseña.contains(" ")) {
            RequisitosMinimos();
            return false;
        }

        System.out.println("Contraseña introducida correcta.");
        return true;
    }

    public static void RequisitosMinimos() {
        System.out.println("Contraseña introducida incorrecta.");

        System.out.println("Requisitos mínimos para la contraseña:");
        System.out.println("- Debe contener al menos 8 caracteres.");
        System.out.println("- Debe contener al menos una letra mayúscula.");
        System.out.println("- Debe contener al menos una letra minúscula.");
        System.out.println("- Debe contener al menos un número.");
        System.out.println("- No debe contener espacios.");
    }
}
