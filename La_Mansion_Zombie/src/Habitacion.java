public class Habitacion implements I_Habitacion{
    /*ATRIBUTOS*/
    int numHabitacion;
    int numZombies;
    int intBusqueda;

    /*CONSTRUCTOR*/
    //Constructor con los valores iniciales de cada atributo
    public Habitacion (int numHabitacion, int numZombies, int intBusqueda) {
        this.numHabitacion = 1;
        this.numZombies = (int) (Math.random()*2+1); //Como máx pueden haber 2 Zombies al mismo tiempo
        this.intBusqueda = 3;
    }


    /*MÉTODOS*/
    //Busqueda (solo si no hay zombies)
    static void realizarBusqueda () {

    }

    //Reducir los intentos (solo 3) y mostrar los intentos restantes
    static void reducirIntentos () {

    }

    //Preparar la siguiente habitación
    public void prepararHabitacion () {

    }

    /*Métodos que implementamos desde la clase I_Habitacion*/
    @Override
    public int getNumHabitacion() {
        return 0;
    }

    @Override
    public int getNumZombie() {
        return 0;
    }

    @Override
    public int getIntentosRestantes() {
        return 0;
    }

    @Override
    public void agregarZ() {

    }

    @Override
    public void eliminarZ() {

    }



    //Mostrar por pantalla los datos de la sala
    @Override
    public String toString() {
        return "*** [NºHABITACIÓN: "+numHabitacion+" || ZOMBIES ACTIVOS: "+numZombies+" || INTENTOS DE BÚSQUEDA: "+intBusqueda+"]";
    }
}
