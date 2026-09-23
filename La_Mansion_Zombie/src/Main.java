import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("BIENVENIDO A LA MANSIÓN ZOMBIE");
        int op;
        do { //Repetimos la pregunta mientras que la opción no sea válida
            mostrarDificultades();
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.print("> OPCIÓN: ");
            op = sc.nextInt();
        } while ((op < 1)||(op > 2));

        System.out.println("----------------------------------------------------------------------------------------");

        if (op == 1) {
            //E_Dificultad.FACIL;
        } else if (op == 2) {
            //E_Dificultad.DIFICIL;
        }
        //Mostramos por pantalla los datos del superviviente
        Superviviente s = new Superviviente(0,0,0);
        System.out.println(s);

        Zombie z = new Zombie(0, 0);
        System.out.println(z);

        Habitacion h = new Habitacion(0, 0, 0);
        System.out.println(h);
        //Número de Zombies en la habitación


    }

    /*Métodos que llamará el main*/
    static void mostrarDificultades () {
        System.out.println("OPCIONES DE DIFICULTAD:");
        System.out.println("1.- FÁCIL (5 habitaciones)");
        System.out.println("2.- DIFÍCIL (10 habitaciones)");
    }

    /*
    //Menú de opciones para cada habitación
    static void mostrarMenu () {
        System.out.println("*** ELIGE UNA DE LAS SIGUIENTES ACCIONES:");

        //Si hay zombies en la habitación, solo se puede pelear
        if (true) {
            System.out.println("1.- COMBATIR CONTRA UN ZOMBIE");
        }
    }

    //Generar aleatoriamente cada habitación
    static void generarHabitacion () {
        System.out.println("HABITACIÓN: ");
        System.out.println("*** LA HABITACIÓN CONTIENE: "+3+" ZOMBIES");
        System.out.println("");
    }

    //Generamos un zombie y mostramos su información
    static void infoZombie (Zombie zombie) {
        zombie = new Zombie(0, 0);
    }

    System.out.println("** LA HABITACIÓN CONTIENE: "+(int) (Math.random()*2+1)+" ZOMBIES"); //<- Números de Zombies de la habitación
    */

}