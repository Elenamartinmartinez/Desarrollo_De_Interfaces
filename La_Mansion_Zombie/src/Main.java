import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("BIENVENIDO A LA MANSIÓN ZOMBIE");
        int op;
        do { //Repetimos la pregunta mientras que la opción no sea válida
            System.out.println("OPCIONES DE DIFICULTAD:");
            System.out.println("1.FÁCIL (5 habitaciones)");
            System.out.println("2.DIFÍCIL (10 habitaciones)");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("> OPCIÓN: ");
            op = sc.nextInt();
        } while ((op < 1)||(op > 2));

        System.out.println("----------------------------------------------------------------------------------------");

        //Mostramos por pantalla los datos del superviviente
        Superviviente s = new Superviviente(0,0,0);
        System.out.println(s);
        //Número de Zombies en la habitación
        System.out.println("** LA HABITACIÓN CONTIENE: "+(int) (Math.random()*2+1)+" ZOMBIES"); //<- Números de Zombies de la habitación


    }
}