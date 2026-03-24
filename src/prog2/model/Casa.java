package prog2.model;

public abstract class Casa extends Allotjament {
    private float mida;
    private int habitacions;
    private int placesPersones;

    //Constructor
    public Casa(String nom, String identificador, long dies_temp_alta, long dies_temp_baixa,
                boolean estat, String il_luminacio, float mida, int habitacions, int placesPersones) {
        super(nom, identificador, dies_temp_alta, dies_temp_baixa, estat, il_luminacio);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    //Getters i setters
    public float getMida() { return mida; }

    public void setMida(float mida) { this.mida = mida; }

    public int getHabitacions() { return habitacions; }

    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }

    public int getPlacesPersones() { return placesPersones; }

    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }

    //toStrinng de la superclasse
    @Override
    public String toString(){
        return super.toString() + "Casa{mida=" + mida + ", habitacions=" + habitacions + ", capacitat de persones=" + placesPersones + "}. ";
    }

    @Override
    public abstract boolean correcteFuncionament();

}
