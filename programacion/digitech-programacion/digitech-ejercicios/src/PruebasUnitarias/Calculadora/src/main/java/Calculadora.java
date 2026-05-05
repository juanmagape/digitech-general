public class Calculadora {

    public static Float suma(float a, float b) {
        if (a < 0 || b < 0) {
            System.out.println("No se puede sumar negativos");
            return null;
        }

        float res = a + b;

        return res;
    }

    public static Float resta(float a, float b) {
        float res = a - b;

        return res;
    }

    public static Float division(float a, float b) {

        if (a == 0 || b == 0) {
            System.out.println("No se puede dividir por cero");
            return null;
        }

        if (a < 0 || b < 0) {
            System.out.println("No se puede dividir negativos");
            return null;
        }

        float res = a / b;

        return res;
    }

    public static Float multiplicacion(float a, float b) {

        if (a == 0 || b == 0) {
            System.out.println("No se puede multiplicar por cero");
            return null;
        }

        float res = a * b;

        return res;
    }
}
