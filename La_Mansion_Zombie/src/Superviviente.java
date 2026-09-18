import java.util.Scanner;

public class Superviviente {
    /*ATRIBUTOS*/
    private int pv;
    private int armas;
    private int proteccion;

    /*CONSTRUCTOR*/
    public Superviviente (int pv, int armas, int proteccion) {
        this.pv = 20; //Los atributos que saldrán por defecto
        this.armas = 0;
        this.proteccion = 0;
    }

    /*MÉTODOS*/
    //Getters y Setters para los atributos
    public void setPv(int pv) {
        this.pv = 20;
    }
    public int getPv() {
        return pv;
    }

    public void setArmas(int armas) {
        this.armas = 0;
    }
    public int getArmas() {
        return armas;
    }

    public void setProteccion(int proteccion) {
        this.proteccion = 0;
    }
    public int getProteccion() {
        return proteccion;
    }


    //Ataque
    static void atacar () {
        int lanzamiento = (int) (Math.random() * 4 + 1);
    }

    //Busqueda
    static void laBusqueda () {
        Scanner sc = new Scanner(System.in);
        int lanzamiento = (int) (Math.random() * 100 + 1);

        System.out.println("Lanzando dados...");
        System.out.println("Has sacado: "+lanzamiento);

       //Dependiendo del resultado
       if (lanzamiento <= 75) { //Entre 1-75
           System.out.println("¡Has hecho ruido!, ¡Cuidado!...");
           int l = (int) (Math.random() * 100 + 1); //Volvemos a lanzar los dados
            if (l <= 40){
                System.out.println("No ha pasdo nada");
            } else if ((l <= 80)&&(l >= 41)) {
                System.out.println("+1 Zombie en la habitación");
            } else if ((l >= 81)&&(l <= 100)) {
                System.out.println("+2 Zombies en la habitación");
            }

       } else if ((lanzamiento >= 76)&&(lanzamiento <= 90)) {
           System.out.println("!Has encontrado un botiquín¡");

       } else if ((lanzamiento >= 91)&&(lanzamiento <= 95)) {
           System.out.println("Encontramos una protección (+1)");
           //Sumar una de protección

       } else if ((lanzamiento >= 96)&&(lanzamiento <= 100)) {
           System.out.println("Encontramos un arma (+1)");
       }
    }

    //Mostramos la información del superviviente por pantalla
    @Override
    public String toString() {
        return "** PV: "+pv+" || ARMAS: "+armas+" || PROTECCIÓN: "+proteccion;
    }
}
