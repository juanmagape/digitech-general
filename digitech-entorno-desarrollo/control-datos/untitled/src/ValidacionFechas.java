import java.util.Scanner;

public class ValidacionFechas {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);


        while(true) {
            System.out.println("Introduce una fecha");

            if (print.hasNextInt()) {
                int dia = print.nextInt();
                int mes = print.nextInt();
                int anyo = print.nextInt();
                
                boolean fechaValida = false;

                if (mes == 2) {
                    if (dia >= 1 && dia <= 28) {
                        fechaValida = true;
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia >= 1 && dia <= 30) {
                        fechaValida = true;
                    }
                } else if (mes >= 1 && mes <= 12) {
                    if (dia >= 1 && dia <= 31) {
                        fechaValida = true;
                    }
                }

                if (fechaValida && anyo > 0 && anyo < 2030) {
                    System.out.println("Fecha valida");
                    System.out.println(dia + "-" + mes + "-" + anyo);
                    break;

                } else {
                    System.out.println("Fecha no valida");
                }


            } else {
                System.out.println("Fecha no valida");
                print.next();
            }
        }
    }
}