package mansion_zombie;

import java.util.Scanner;

public class Superviviente implements I_Combate {
    private static final int MAX_PV = 20;
    private int pv = MAX_PV;
    private int ataque = 4;
    private int armas = 0;
    private int proteccion = 0;
    private boolean botiquin = false;

    @Override
    public int atacar() {
        return (int) (Math.random() * ataque) + 1 + armas; //Varia dependiendo de si el superviviente tiene armas o no
    }

    @Override
    public int recibirDanio(int danio) {
        int danioReal = Math.max(0, danio - proteccion);//Si se encuentra protección se reduce el daño recibido
        pv = Math.max(0, pv - danioReal);
        return danioReal;
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

    public boolean tieneBotiquin() { return botiquin; }

    /** @return true si lo ha podido coger */
    public boolean recogerBotiquin() {
        if (botiquin) return false;
        botiquin = true;
        return true;
    }
    public void sumarArma() { armas++; }
    public void sumarProteccion() { proteccion++; }

    public void curarse() {
        if (!botiquin) return;
        pv = Math.min(MAX_PV, pv + 4);
        botiquin = false;
    }

    @Override
    public String toString() {
        return "** PV: " + pv + " #MAX(" + MAX_PV + "); ARMAS: " + armas
             + "; PROTECCIÓN: " + proteccion + (botiquin ? "; BOTIQUÍN: SÍ" : "");
    }
}