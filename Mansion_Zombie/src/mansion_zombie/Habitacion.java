package mansion_zombie;

public class Habitacion implements I_Habitacion {

    private static final int INTENTOS_INICIALES = 3;
    private int numHabitacion = 1;
    private int numZombies = 1;
    private int intentosBusqueda = INTENTOS_INICIALES;

    public E_Busqueda realizarBusqueda() {
        intentosBusqueda--;//Resta los intentos del jugador
        int tirada = (int) (Math.random() * 100) + 1;//El dado da números aleatorios
        if (tirada <= 75) {
            return E_Busqueda.RUIDO;
        }
        if (tirada <= 90) {
            return E_Busqueda.BOTIQUIN;
        }
        if (tirada <= 95) {
            return E_Busqueda.PROTECCION;
        }
        return E_Busqueda.ARMA;
    }

    //En caso de que el jugador haya hecho ruido, tiene una segunda oportunidad para
    //no invocar zombies
    public int resolverRuido() {
        int tirada = (int) (Math.random() * 100) + 1;
        int nuevos = tirada <= 40 ? 0 : (tirada <= 80 ? 1 : 2);//Si la tirada es inferior a 40, se invoca un número de zombies (como máx 2)
        numZombies += nuevos; //Añade los zombies nuevos
        return nuevos;
    }

    //Se crea nueva información para cada habitación
    @Override
    public void prepararHabitacion() {
        numHabitacion++;
        numZombies = 1; //Realmente el mínimo son 0 zombies, de momento dejar así
        intentosBusqueda = INTENTOS_INICIALES;
    }

    @Override
    public int getNumHabitacion() {
        return numHabitacion;
    }

    @Override
    public int getNumZombie() {
        return numZombies;
    }

    @Override
    public int getIntentosRestantes() {
        return intentosBusqueda;
    }

    @Override
    public void agregarZ() {
        numZombies++;
    }

    @Override
    public void eliminarZ() {
        if (numZombies > 0) {
            numZombies--;
        }
    }

    @Override
    public String toString() {
        return "** LA HABITACIÓN CONTIENE: " + numZombies + " ZOMBIES.";
    }
}