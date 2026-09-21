import java.util.Scanner;

public class Superviviente implements I_Combate{
    /*ATRIBUTOS*/
    private final int maxPv = 20;//Vida máx, al curarse solo puede llegar a 20
    private int pv;
    private int ataque;
    private int armas;
    private int proteccion;
    private boolean botiquin = false;

    /*CONSTRUCTOR*/
    //Constructor con solo los valores iniciales
    public Superviviente (int pv, int armas, int proteccion) {
        this.pv = 20; //Los atributos que saldrán por defecto
        this.armas = 0;
        this.proteccion = 0;
    }

    //Constructor con todos los valores
    public Superviviente (int pv, int ataque, int armas, int proteccion, boolean botiquin) {
        this.pv = 20; //Los atributos que saldrán por defecto
        this.ataque = 4;
        this.armas = 0;
        this.proteccion = 0;
        this.botiquin = false;
    }

    /*MÉTODOS*/
    //Getters y Setters para los atributos
    public void setPv(int pv) {
        this.pv = 20;
    }
    public int getPv() {
        return pv;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getAtaque() {
        return ataque;
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

    public void setBotiquin(boolean botiquin) {
        this.botiquin = botiquin;
    }

    //Ataque
    public int atacar () {
        int lanzamiento = ((int) (Math.random() * 4 + 1)) + ataque;
        return (int) lanzamiento + armas;
    }

    /*Métodos que implementamos de la clase I_Combatir*/
    //Recibir daño de ataque
    @Override
    public int recibirDanio(int danio) {
        int danioT = danio - proteccion; //En caso de tener alguna protección, reduce el daño
        if (danioT < 0) {
            danioT = 0;
        }

        this.pv -= danioT;
        if (pv < 0) {
            pv = 0; //La vida nunca puede ser menor a 0
        }
        return danio;
    }

    //Estado del superviviente
    @Override
    public boolean estado() {
        return this.pv > 0;
    }

    //Curarse
    public void curarse() {
        //Solo mostramos la opción de curar en caso de que el superviviente tenga botiquín
        if (this.botiquin) { //Si tiene, puede usarlo aunque la vida este al max
            this.pv += 4;

            if (this.pv > this.maxPv) {
                this.pv = this.maxPv; //El jugador es libre de decidir si lo usa o no, pero con vida max no va a pasar de 20pv
            }
            this.botiquin = false; //Una vez usado, se elimina el botiquín del inventario
            System.out.println("¡Te has curado!");
            System.out.println("Punto de vida actuales: "+this.pv); //Mostramos el pv por pantalla
        }
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

       } else {
           System.out.println("Encontramos un arma (+1)");
       }
    }

    //Mostramos la información del superviviente por pantalla
    @Override
    public String toString() {
        return "** PV: "+pv+" || ARMAS: "+armas+" || PROTECCIÓN: "+proteccion;
    }
}