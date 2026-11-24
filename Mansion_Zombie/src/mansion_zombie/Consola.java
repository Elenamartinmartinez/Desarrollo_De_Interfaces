package mansion_zombie;

import java.util.Scanner;

public class Consola {
    private static final Scanner sc = new Scanner(System.in);
    public static final String LINEA = "-".repeat(88);

    public static int leerOpcion(int min, int max) {
        while (true) {
            System.out.print("> OPCIÓN: ");
            
            try {
                int op = Integer.parseInt(sc.nextLine().trim());
                if (op >= min && op <= max) return op;
                System.out.println("Opción fuera de rango (" + min + "-" + max + ").");
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }
}
