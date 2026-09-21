public enum E_Dificultad {
    FACIL (5),
    DIFICIL (10);

    private final int maxHabitaciones;

    E_Dificultad(int maxHabitaciones) {
        this.maxHabitaciones = maxHabitaciones;
    }
    public int getMaxHabitaciones () {
        return maxHabitaciones;
    }
}
