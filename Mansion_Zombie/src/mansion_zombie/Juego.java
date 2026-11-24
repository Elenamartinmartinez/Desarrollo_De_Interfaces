package mansion_zombie;

public class Juego {

    private final E_Dificultad dificultad;
    private final Superviviente superviviente;
    private final Habitacion habitacion;
    private boolean victoria = false;

    public Juego() {
        System.out.println(Consola.LINEA);
        System.out.println("---------------- BIENVENIDO A LA MANSIÓN ZOMBIE ----------------");

        System.out.println("ELIGE DIFICULTAD:");
        System.out.println("1. FÁCIL (" + E_Dificultad.FACIL.getMaxHabitaciones() + " HABITACIONES)");
        System.out.println("2. DIFÍCIL (" + E_Dificultad.DIFICIL.getMaxHabitaciones() + " HABITACIONES)");
        System.out.println("-----------------------------------------------------------------");

        this.dificultad = (Consola.leerOpcion(1, 2) == 1) ? E_Dificultad.FACIL : E_Dificultad.DIFICIL;
        this.superviviente = new Superviviente();
        this.habitacion = new Habitacion();
    }

    //Se ejecuta mientras que la partida no esté terminada
    public void iniciar() {
        while (!partidaTerminada()) {
            mostrarEstado();
            mostrarMenu();
            ejecutarAccion(Consola.leerOpcion(1, 4));
        }
        mostrarResultado();
    }

    private boolean partidaTerminada() {//La partida acaba si el juego se completa o si el superviviente
        //muere antes de acabar la partida
        return victoria || !superviviente.estado();
    }

    private boolean hayZombies() {
        return habitacion.getNumZombie() > 0;
    }

    private boolean esUltimaHabitacion() {
        return habitacion.getNumHabitacion() == dificultad.getMaxHabitaciones();
    }

    private void mostrarEstado() {//Muestra por pantalla el estado de la partida o la vida del jugador
        System.out.println(Consola.LINEA);
        System.out.println(superviviente);
        System.out.println(habitacion);
    }

    private void mostrarMenu() {
        System.out.println("* ELIGE UNA ACCIONES:");
        if (hayZombies()) { //Única opción que se dará en caso de haber zombies en la habitación
            System.out.println("1. COMBATIR CONTRA UN ZOMBIE.");
            return;
        }
        //Si tenemos intentos restantes y no hay zombies en la habitación se darán otras opciones
        if (habitacion.getIntentosRestantes() > 0) {
            System.out.println("2. BUSCAR POR LA HABITACIÓN (" + habitacion.getIntentosRestantes() + " INTENTOS).");
        }
        //Si no es la última habitación se sigue avanzando, si no se da la opción de abandonar la mansión
        System.out.println("3. " + (esUltimaHabitacion() ? "SALIR DE LA MANSIÓN." : "AVANZAR A OTRA HABITACIÓN."));
        if (superviviente.tieneBotiquin()) {
            System.out.println("4. CURARSE."); //Solo si el jugador tiene el botiquín de antes o lo encontró buscando en la habitación
        }
    }

    //Dependiendo de lo elegido por el jugador se ejecutará una acción u otra
    private void ejecutarAccion(int accion) {
        boolean libre = !hayZombies();
        if (hayZombies() && accion == 1) {
            combatir();
        } else if (libre && accion == 2 && habitacion.getIntentosRestantes() > 0) {
            buscar();
        } else if (libre && accion == 3) {
            avanzar();
        } else if (libre && accion == 4 && superviviente.tieneBotiquin()) {
            curarse();
        } else {
            System.out.println("Esa acción no está disponible ahora.");
        }
    }

    private void combatir() {
        Zombie zombie = new Zombie(habitacion.getNumHabitacion());
        System.out.println(zombie);
        int ronda = 1;
        while (superviviente.estado() && zombie.estado()) {
            System.out.println(">> RONDA: " + ronda++);
            int danio = superviviente.atacar();
            System.out.println("> El superviviente ataca con valor " + danio);//El daño puede variar dependiendo de si tiene armas
            zombie.recibirDanio(danio); //Puede recibir menos daño si cuenta con alguna protección
            if (!zombie.estado()) {
                System.out.println("Has eliminado al zombie.");
                habitacion.eliminarZ();
                return;
            }
            int danioZombie = zombie.atacar();
            System.out.println("> El zombie ataca con valor " + danioZombie);//El daño del zombie puede variar dependiendo de la habitación
            superviviente.recibirDanio(danioZombie);//El pv del zombie puede variar dependiendo de la habitación
        }
    }

    private void buscar() {
        switch (habitacion.realizarBusqueda()) { //Las diferentes opciones de realizar una busqueda
            case RUIDO -> { //Hacer ruido (aún hay posibilidades de no atraer a algún zombie(s))
                System.out.println("¡Has hecho ruido!, ¡cuidado!...");
                int nuevos = habitacion.resolverRuido();
                System.out.println(nuevos == 0
                        ? "... por suerte nadie te escucha al otro lado esta vez."
                        : "... ¡+" + nuevos + " zombie(s) en la habitación!");
            }
            case BOTIQUIN ->//Ahora el superviviente puede sanarse después de combatir
                System.out.println(superviviente.recogerBotiquin()
                        ? "¡Has encontrado un botiquín!"
                        : "Encuentras un botiquín, pero ya llevas uno.");//Solo se permite llevar uno
            case PROTECCION -> {
                superviviente.sumarProteccion();
                System.out.println("Encuentras una protección (+1).");//A más protección menos daño que recibe el superviviente
            }
            case ARMA -> {
                superviviente.sumarArma();
                System.out.println("Encuentras un arma (+1).");//Sube el ataque
            }
        }
    }
    //En caso de que el superviviente llegue vivo a la última habitación
    private void avanzar() {
        if (esUltimaHabitacion()) {
            victoria = true;
        } else {
            habitacion.prepararHabitacion();
        }
    }

    private void curarse() {//Solo podrá curarse cuando tenga un botiquín
        superviviente.curarse();
        System.out.println("¡Te has curado! PV actuales: " + superviviente.getPv());
    }

    private void mostrarResultado() {
        System.out.println(Consola.LINEA);
        System.out.println(victoria ? "¡VICTORIA! Has salido de la mansión." : "GAME OVER");
    }
}