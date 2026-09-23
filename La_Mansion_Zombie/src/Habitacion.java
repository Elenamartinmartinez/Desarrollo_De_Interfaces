public class Habitacion implements I_Habitacion{
    /*ATRIBUTOS*/
    int numHabitacion;
    int numZombies;
    int intBusqueda;

    /*CONSTRUCTOR*/
    //Constructor con los valores iniciales de cada atributo
    public Habitacion (int numHabitacion, int numZombies, int intBusqueda) {
        this.numHabitacion = 1;
        this.numZombies = (int) (Math.random()*2); //Como máx pueden haber 2 Zombies al mismo tiempo
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
    public int getNumHabitacion() { //Tener en cuenta que dependiendo de la dificultad pueden ser 5 o 10
        if (true) { //Dificultad baja

        } else  if (true) { //Dificultad alta

        }
        return 0;
    }

    @Override
    public int getNumZombie() { //Solo se pueden tener como máx 2 zombies al mismo tiempo

        return 0;
    }

    @Override
    public int getIntentosRestantes() {
        return 0;
    }

    @Override
    public void agregarZ() { //Si se hace ruido y hay mala suerte, se suma x número de zombies

    }

    @Override
    public void eliminarZ() { //En caso de que la vida del zombie llegue a 0

    }



    //Mostrar por pantalla los datos de la sala
    @Override
    public String toString() {
        return "*** [NºHABITACIÓN: "+numHabitacion+" || ZOMBIES ACTIVOS: "+numZombies+" || INTENTOS DE BÚSQUEDA: "+intBusqueda+"]";
    }
}