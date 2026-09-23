import java.util.*;

public class Zombie implements I_Combate{
    static Scanner sc = new Scanner (System.in);

    Habitacion h = new Habitacion(0,0,0);
    /*ATRIBUTOS*/
    int pv; //<- num aleatorio (0-1) + 2 + (habitación - 1)
    int ataque; //<- num aleatorio (0-1) + 2 + (habitación - 1)

    /*CONSTRUCOTR*/
    //Todos sus atributos se crean de manera aleatoria
    public Zombie (int pv, int ataque) {
        this.pv = (int) (Math.random() * 2 + 1) + 2 + (h.numHabitacion - 1);
        this.ataque = (int) (Math.random() * 2 + 1) + (h.numHabitacion - 1);
    }

    /*MÉTODOS*/
    //Atacar
    public int atacar () {
        int lanzamiento = ((int) (Math.random() * 4 + 1)) + ataque;
        return lanzamiento;
    }

    /*Métodos que implementamos desde la clase I_Combatir*/
    @Override
    public int recibirDanio(int danio) {
        int danioT = danio; //El zombie no tiene protección, no se reduce el daño que se le haga
        if (danioT < 0) {
            danioT = 0;
        }

        this.pv -= danioT;
        if (pv < 0) {
            pv = 0; //La vida nunca puede ser menor a 0
        }
        return danio;
    }

    @Override
    public boolean estado() {
        return this.pv > 0;
    }

    @Override
    public int getPv() {
        return this.pv;
    }

    @Override
    public int getAtaque() {
        return this.ataque;
    }


    //Mostrar por pantalla los atributos del zombie al pelar
    @Override
    public String toString() {
        return "El zombie tiene "+pv+" puntos de vida.\t" +
                "El zombie tiene "+ataque+" puntos de ataque.";
    }
}