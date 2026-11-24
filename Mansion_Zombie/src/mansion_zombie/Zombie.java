package mansion_zombie;

import java.util.*;

public class Zombie implements I_Combate {
    private int pv;
    private int ataque;

    public Zombie(int numHabitacion) {
        this.pv = (int) (Math.random() * 2) + 2 + (numHabitacion - 1);
        this.ataque = (int) (Math.random() * 2) + 2 + (numHabitacion - 1);
    }

    @Override
    public int atacar() {
        return (int) (Math.random() * ataque) + 1; //el dado da un poder de ataque aleatorio
    }

    @Override
    public int recibirDanio(int danio) {
        pv = Math.max(0, pv - danio);//Variara dependiendo del ataque del superviviente y la vida del zombie
        return danio;
    }

    @Override
    public boolean estado() {
        return pv > 0;
    }
    @Override
    public int getPv() {
        return pv;
    }
    @Override
    public int getAtaque() {
        return ataque;
    }

    @Override
    public String toString() {
        return "El zombie tiene " + ataque + " puntos de ataque.\n"
             + "El zombie tiene " + pv + " puntos de vida.";
    }
}