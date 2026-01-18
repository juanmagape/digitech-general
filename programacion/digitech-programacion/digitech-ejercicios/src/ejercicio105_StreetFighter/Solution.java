package ejercicio105_StreetFighter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String estado = print.next();
        String evento = print.next();
        if (estado.equals("PUNCHING")) {
            System.out.println("PUNCHING");
        } else {
            switch (estado) {
                case "IDLE":
                    Evento(evento);
                    break;
                case "WALKING":
                    Evento(evento);
                    break;
                case "JUMPING":
                    Evento(evento);
                    break;
                case "KICK":
                    Evento(evento);
                    break;
                case "PUNCHING":
                    Evento(evento);
                    break;
            }
        }
    }

    public static void Evento(String evento) {
        switch (evento) {
            case "JOYSTICK_LEFT/RIGHT":
                System.out.println("WALKING");
                break;
            case "JOYSTICK_CENTER":
                System.out.println("IDLE");
                break;
            case "PUNCH_KEY":
                System.out.println("PUNCHING");
                break;
            case "KICK_KEY":
                System.out.println("KICKING");
                break;
            case "PUNCH_END":
                System.out.println("PUNCHING");
                break;
            case "KICK_END":
                System.out.println("KICKING");
                break;
            case "TOUCH_FLOOR":
                System.out.println("IDLE");
                break;
            case "JOYSTICK_UP":
                System.out.println("JUMPING");
                break;
        }
    }
}