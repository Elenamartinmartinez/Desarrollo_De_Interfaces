public class Zombie {
    /*ATRIBUTOS*/
    int pv; //<- num aleatorio (0-1) + 2 + (habitación - 1)
    int ataque; //<- num aleatorio (0-1) + 2 + (habitación - 1)

    /*CONSTRUCOTR*/

    /*MÉTODOS*/
    //Mostrar por pantalla los atributos del zombie al pelar
    @Override
    public String toString() {
        return "El zombie tiene "+pv+" puntos de vida.\t" +
                "El zombie tiene "+ataque+" puntos de ataque.";
    }
}
